import ManaCost from "../mana-cost/ManaCost";

const CardData = ({card}) => {
    return (
        <div className="flex flex-col w-1/2 border-2 border-black">
            <div className="flex flex-row">
                {card?.name} <ManaCost manaCost={card?.manaCost} />
            </div>
            <div>{card?.type}</div>
            <div className="flex flex-col">
                <div>{card?.oracleText}</div>
                <div className="italic">{card?.flavorText}</div>
            </div>
        </div>
    );
}

export default CardData;