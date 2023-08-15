const CardCollectionData = ({expansion, card}) => {
    return (
        <div className="w-1/4 text-gray-700">
            <div className="flex flex-row justify-between">
                <div className="w-1/6">
                    <img
                        src={expansion.iconPath}
                        alt={expansion.name}
                        className="max-w-none w-[50px] h-[50px]"
                    />
                </div>
                <div className="w-2/3">
                    <div>
                        {expansion.name} - ({expansion.code})
                    </div>
                    <div className="capitalize">
                        {expansion.setType}
                    </div>
                </div>
            </div>
            <div className="mt-4">
                <table className="border w-full">
                    <thead>
                    <tr className="border">
                        <th></th>
                        <th className="text-left">Non foil</th>
                        <th className="text-left">Foil</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr className="border">
                        <td>Price</td>
                        <td>{card?.price?.nonFoil}</td>
                        <td>{card?.price?.foil}</td>
                    </tr>
                    <tr className="border">
                        <td>Collected</td>
                        <td>{card?.quantity?.nonFoil}</td>
                        <td>{card?.quantity?.foil}</td>
                    </tr>
                    <tr className="border">
                        <td>Total</td>
                        <td>{card?.price?.nonFoil * card?.quantity?.nonFoil}</td>
                        <td>{card?.price?.foil * card?.quantity?.foil}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default CardCollectionData;