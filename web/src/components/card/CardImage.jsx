const CardImage = ({card}) => {
    return (
        <div className="w-1/4">
            <img src={card?.image?.normalUrl} alt={card.name}/>
        </div>
    );
}

export default CardImage;