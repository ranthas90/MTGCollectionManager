import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import ExpansionCardsTable from "./ExpansionCardsTable";
import InputControl from "../../lib/InputControl";
import SelectControl from "../../lib/SelectControl";
import PageTitle from "../../lib/PageTitle";
import useLocalStorage from "../../../hooks/useLocalStorage";

const ExpansionCardsContainer = () => {

    const {code} = useParams();
    const [cards, setCards] = useState([]);
    const [searchCards, setSearchCards] = useState([]);
    const [expansion, setExpansion] = useState({});
    const storage = useLocalStorage();

    const rarities = [
        {value: 'common', text: 'Common'},
        {value: 'uncommon', text: 'Uncommon'},
        {value: 'rare', text: 'Rare'},
        {value: 'mythic', text: 'Mythic'},
    ];
    
    const filterCardsByRarity = (rarity) => {
        if (rarity === "") {
            setCards(searchCards);
        } else {
            setCards(searchCards.filter(card => card.rarity.toLowerCase() === rarity.toLowerCase()));
        }
    }

    const filterCardsByName = (name) => {
        setCards(searchCards.filter(card => card.name.toLowerCase().includes(name.toLowerCase())));
    };

    useEffect(() => {
        fetch(`http://localhost:8080/sets/${code}/cards`)
            .then(res => res.json())
            .then(data => {
                setCards(data);
                setSearchCards(data);
                storage.store('cards_navigation', data.map(item => item.slug));
            });

        fetch(`http://localhost:8080/sets/${code}`)
            .then(res => res.json())
            .then(data => setExpansion(data));

    }, [code]);

    return (
        <div className="flex flex-col items-center min-h-screen pt-3">
            <div className="w-11/12">
                <div className="flex flex-row justify-between">
                    <PageTitle title={`${expansion.name} expansion`} />
                    <div className="flex flex-row-reverse w-1/4">
                        <SelectControl
                            options={rarities}
                            placeholder="Search by rarity"
                            onChangeHandler={filterCardsByRarity}
                        />
                        <InputControl
                            placeholder="Search by name"
                            onChangeHandler={filterCardsByName}
                        />
                    </div>
                </div>
                <div className="bg-white shadow rounded-md overflow-hidden my-6">
                    <ExpansionCardsTable expansion={expansion} cards={cards} />
                </div>
            </div>
        </div>
    )
}

export default ExpansionCardsContainer;