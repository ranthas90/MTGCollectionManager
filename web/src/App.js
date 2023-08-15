import './App.css';
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import Layout from "./layout/Layout";
import ExpansionsTableContainer from "./components/expansion/table/ExpansionsTableContainer";
import ExpansionCardsContainer from "./components/expansion/cards/ExpansionCardsContainer";
import CardContainer from "./components/card/CardContainer";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route path="/" element={<Navigate to={"/expansions"} />} />
            <Route path="/expansions" element={<ExpansionsTableContainer />} />
            <Route path="/expansions/:code/cards" element={<ExpansionCardsContainer />} />
            <Route path="/expansions/:code/cards/:slug" element={<CardContainer />} />
          </Route>
        </Routes>
      </BrowserRouter>
  )
}

export default App;
