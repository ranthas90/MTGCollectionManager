import ExpansionsTableRow from "./ExpansionsTableRow";

const ExpansionsTable = ({expansions}) => {
    return (
        <table className="table w-full border-collapse space-y-6 text-gray-700">
            <thead className="border-b bg-indigo-800 font-medium uppercase text-sm text-gray-100">
                <tr>
                    <th className="p-3">Name</th>
                    <th className="p-3 text-left">Type</th>
                    <th className="p-3 text-left">Collection</th>
                    <th className="p-3 text-left">Progress</th>
                    <th className="p-3">Actions</th>
                </tr>
            </thead>
            <tbody>
            {expansions && expansions.map((expansion) => (
                <ExpansionsTableRow key={`tr_${expansion.code}`} expansion={expansion} />
            ))}
            </tbody>
        </table>
    )
}

export default ExpansionsTable;