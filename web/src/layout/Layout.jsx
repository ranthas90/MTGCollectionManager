import {Outlet} from "react-router-dom";
import Sidebar from "./Sidebar";
import SidebarItem from "./SidebarItem";
import {FaBoxArchive, FaCartShopping, FaGear} from "react-icons/fa6";

const Layout = () => {
    return (
        <div className="flex flex-row min-h-screen">
            <div className="w-1/8 bg-gray-900 shadow flex-col justify-between">
                <div className="w-full flex items-center bg-red-300">
                    Imagen de un logo o bien solo el texto?
                </div>
                <Sidebar>
                    <SidebarItem label="Expansions" icon={<FaBoxArchive className="w-6 h-6" />} link="/expansions" />
                    <SidebarItem label="Cardmarket" icon={<FaCartShopping className="w-6 h-6" />} link="/expansions" />
                    <SidebarItem label="Settings" icon={<FaGear className="w-6 h-6" />} link="/expansions" />
                </Sidebar>
            </div>
            <div className="w-7/8 min-h-screen bg-gray-200">
                <Outlet />
            </div>
        </div>
    );
}

export default Layout;