import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import CardImage from "./CardImage";
import CardData from "./CardData";
import CardCollectionData from "./CardCollectionData";

const CardContainer = () => {

    const {code, slug} = useParams();
    const [expansion, setExpansion] = useState({});
    const [card, setCard] = useState({});

    useEffect(() => {
        fetch(`http://localhost:8080/sets/${code}/cards/${slug}`)
            .then(res => res.json())
            .then(data => setCard(data));

        fetch(`http://localhost:8080/sets/${code}`)
            .then(res => res.json())
            .then(data => setExpansion(data));

    }, [code, slug]);

    return (
        <div className="flex flex-col items-center min-h-screen pt-3">
            <div className="w-11/12 flex flex-col p-8 bg-white shadow-md rounded-md border overflow-hidden h-[90vh]">
                <div className="flex flex-row gap-x-4">
                    <CardImage card={card} />
                    <CardData card={card} />
                    <CardCollectionData expansion={expansion} card={card} />
                </div>
            </div>
        </div>
    )
}

export default CardContainer;