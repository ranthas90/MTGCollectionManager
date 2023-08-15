import {useState} from "react";
import {Link} from "react-router-dom";
import {AiFillEdit, AiOutlineEdit} from "react-icons/ai";
import {FaGear} from "react-icons/fa6";

const ExpansionsTableRow = ({expansion}) => {

    const [ownedPercent, setOwnedPercent] = useState(((expansion.ownedCards / expansion.totalCards) * 100).toFixed(2));

    return (
        <tr className="hover:bg-gray-200 border-b">
           <td className="p-3">
               <div className="flex align-items-center">
                   <img
                       className="rounded-full h-12 w-12 object-cover"
                       src={expansion.iconPath}
                       alt={expansion.name}
                   />
                   <div className="ml-3">
                       <Link className="font-bold" to={`/expansions/${expansion.code}/cards`}>
                           {expansion.name}
                       </Link>
                       <div className="text-gray-500">
                           Released at {expansion.releaseDate}
                       </div>
                   </div>
               </div>
           </td>
            <td className="p-3 capitalize">
                {expansion.setType}
            </td>
            <td className="p-3">
                {expansion.ownedCards} / {expansion.totalCards}
            </td>
            <td className="p-3">
                <div className="flex items-center">
                    <span className="mr-2">
                        {ownedPercent}%
                    </span>
                    <div className="relative w-full">
                        <div className="overflow-hidden h-2 text-xs flex rounded bg-purple-200">
                            <div
                                style={{width: `${ownedPercent}%`}}
                                className="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-purple-500">
                            </div>
                        </div>
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

export default ExpansionsTableRow;