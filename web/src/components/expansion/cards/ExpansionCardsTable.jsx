import ExpansionCardsTableRow from "./ExpansionCardsTableRow";

const ExpansionCardsTable = ({expansion, cards}) => {
    return (
        <table className="table w-full border-collapse space-y-6 text-gray-700">
            <thead className="border-b bg-indigo-800 font-medium uppercase text-sm text-gray-100">
            <tr>
                <th className="p-3 text-left">Nº</th>
                <th className="p-3 text-left">Name</th>
                <th className="p-3 text-left">Rarity</th>
                <th className="p-3 text-left">Quantity</th>
                <th className="p-3 text-left">Price</th>
                <th className="p-3 text-left">Foil price</th>
                <th className="p-3 text-left">Actions</th>
            </tr>
            </thead>
            <tbody>
            {cards && cards.map((card) => (
                <ExpansionCardsTableRow
                    key={`tr_${card.slug}`}
                    card={card}
                    expansion={expansion}
                />
            ))}
            </tbody>
        </table>
    )
}

export default ExpansionCardsTable;