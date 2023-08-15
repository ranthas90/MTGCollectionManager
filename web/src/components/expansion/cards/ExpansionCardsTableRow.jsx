import {Link, useNavigate} from "react-router-dom";
import ManaCost from "../../mana-cost/ManaCost";
import {AiFillEdit, AiOutlineEdit} from "react-icons/ai";
import {BsGear} from "react-icons/bs";
import PlusButton from "../../lib/PlusButton";
import MinusButton from "../../lib/MinusButton";
import {useState} from "react";
import {FaGear} from "react-icons/fa6";

const ExpansionCardsTableRow = ({card, expansion}) => {

    const [quantity, setQuantity] = useState(card.quantity);

    const updateQuantity = (isAddition, isFoil) => {
        const request = {
            nonFoil: isFoil ? quantity.nonFoil : modify(isAddition, quantity.nonFoil),
            foil: isFoil ? modify(isAddition, quantity.foil) : quantity.foil,
        };

        fetch(`http://localhost:8080/sets/${expansion.code}/cards/${card.slug}`, {
            method: "PUT",
            body: JSON.stringify(request),
            headers: { "Content-type": "application/json" },
        })
            .then((res) => res.json())
            .then((data) => setQuantity(data.quantity));
    };

    const modify = (isAddition, quantity) => {
        if (isAddition) {
            return quantity === 4 ? quantity : quantity + 1;
        } else {
            return quantity === 0 ? quantity : quantity - 1;
        }
    };

    return (
        <tr className="hover:bg-gray-200 border-b">
            <td className="p-3">
                {card.collectorNumber}
            </td>
            <td className="p-3">
                <div className="flex align-items-center">
                    <img
                        className="rounded-full h-12 w-12 object-cover"
                        src={card?.image?.artCropUrl}
                        alt={card.name}
                    />
                    <div className="ml-3">
                        <div className="flex flex-row">
                            <Link className="font-bold" to={`/expansions/${expansion.code}/cards/${card.slug}`}>
                                {card.name}
                            </Link>
                            <div className="ml-1">
                                - {card.type}
                            </div>
                        </div>
                        <div className=" mt-1 text-gray-500">
                            <ManaCost manaCost={card.manaCost} />
                        </div>
                    </div>
                </div>
            </td>
            <td className="p-3 capitalize">
                {card.rarity}
            </td>
            <td className="p-3">
                {quantity?.nonFoil} / {quantity?.foil}
            </td>
            <td className="p-3">
                <div className="flex flex-row">
                    <div className="flex justify-center w-1/2">{card?.price?.nonFoil}</div>
                    <div className="flex justify-center gap-2 w-1/2">
                        <PlusButton onClickHandler={() => updateQuantity(true, false)} />
                        <MinusButton onClickHandler={() => updateQuantity(false, false)} />
                    </div>
                </div>
            </td>
            <td className="p-3">
                <div className="flex flex-row">
                    <div className="flex justify-center w-1/2">{card?.price?.foil}</div>
                    <div className="flex justify-center gap-2 w-1/2">
                        <PlusButton onClickHandler={() => updateQuantity(true, true)} />
                        <MinusButton onClickHandler={() => updateQuantity(false, true)} />
                    </div>
                </div>
            </td>
            <td className="p-3">
                <div className="flex flex-row justify-center">
                    <Link to="/" className="mr-2">
                        <AiFillEdit />
                    </Link>
                    <Link to="/" className="mx-2">
                        <FaGear />
                    </Link>
                </div>
            </td>
        </tr>
    )
}

export default ExpansionCardsTableRow;