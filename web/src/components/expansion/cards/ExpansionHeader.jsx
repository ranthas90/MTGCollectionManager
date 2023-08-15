const ExpansionHeader = ({expansion, totalPrice}) => {
    return (
        <div className="w-full p-4 flex flex-row justify-between bg-white shadow-md rounded-md border overflow-hidden text-gray-700">
            <div className="w-1/6">
                <img
                    src={expansion.iconPath}
                    alt={expansion.name}
                    className="max-w-none w-[100px] h-[100px]"
                />
            </div>
            <div className="w-2/3">
                <div>
                    {expansion.name} - ({expansion.code})
                </div>
                <div>
                    Expansion was released at {expansion.releaseDate}
                </div>
                <div>
                    Aqui ponemos la descripción del settype
                </div>
            </div>
            <div className="w-1/6">
                <div>Collection: {expansion.ownedCards} / {expansion.totalCards}</div>
                <div>Total price: {totalPrice.nonFoil}€ / {totalPrice.foil}€</div>
                <div>Collected price: 1111€ / 2222€</div>
            </div>
        </div>
    )
}

export default ExpansionHeader;