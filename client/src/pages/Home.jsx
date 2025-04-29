import {SideBar, SideBarItem} from "../components/SideBar.jsx";
import { BarChart3, UserCircle, Boxes,  Package, Receipt, LayoutDashboard} from "lucide-react";

function Home() {
    return (
        <main className="flex">
            <SideBar>
                <SideBarItem
                    icon={<LayoutDashboard size={20}/>}
                    text="Dashboard"
                    alert
                />
                <SideBarItem icon={<BarChart3 size={20}/>} text="Home" active />
                <SideBarItem icon={<UserCircle size={20}/>} text="Checkout" />
                <SideBarItem icon={<Boxes size={20}/>} text="Inventory" />
                <SideBarItem icon={<Package size={20}/>} text="Orders" alert/>
                <SideBarItem icon={<Receipt size={20}/>} text="Billings" />
            </SideBar>
            <div className="flex-1 p-4">
                <h1 className="text-2xl font-bold text-center">Jenga Spires Services</h1>
            </div>
        </main>
    );
}
export default Home;
