import {useEffect, useState} from "react";
import ExpansionsTable from "./ExpansionsTable";
import InputControl from "../../lib/InputControl";
import PageTitle from "../../lib/PageTitle";

const ExpansionsTableContainer = () => {

    const [expansions, setExpansions] = useState([]);
    const [searchExpansions, setSearchExpansions] = useState([]);

    const filterExpansions = (value) => {
        setExpansions(
            searchExpansions.filter(expansion => expansion.name.toLowerCase().includes(value.toLowerCase()))
        );
    };

    useEffect(() => {
        fetch('http://localhost:8080/sets')
            .then(res => res.json())
            .then(data => {
                setExpansions(data);
                setSearchExpansions(data);
            });
    }, []);

    return (
        <div className="flex flex-col items-center min-h-screen pt-3">
            <div className="w-[95%]">
                <div className="flex flex-row justify-between">
                    <PageTitle title="Magic The Gathering expansions" />
                    <div className="w-1/4">
                        <InputControl placeholder="Search expansions by name" onChangeHandler={filterExpansions} />
                    </div>
                </div>
                <div className="bg-white shadow rounded-md overflow-hidden my-6">
                    <ExpansionsTable expansions={expansions} />
                </div>
            </div>
        </div>
    )
}

export default ExpansionsTableContainer;