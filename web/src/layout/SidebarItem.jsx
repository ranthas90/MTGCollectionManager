import {Link} from "react-router-dom";

const SidebarItem = ({label, icon, link}) => {
    return (
        <div className="flex items-center px-6 py-2 mt-4 text-gray-500 hover:bg-gray-700 hover:bg-opacity-25 hover:text-gray-100">
            <Link to={link} className="flex w-full items-center focus:outline-none">
                {icon}
                <span className="mx-3">
                    {label}
                </span>
            </Link>
        </div>
    );
}

export default SidebarItem;