import tour1 from "./images/tour-1.jpeg";
import tour2 from "./images/tour-2.jpeg";
import tour3 from "./images/tour-3.jpeg";

export const pageLinks = [
  { id: 1, href: "#home", text: "home" },
  { id: 2, href: "#about", text: "about" },
  { id: 3, href: "#services", text: "services" },
  { id: 4, href: "#tours", text: "tours" },
];
export const socialLinks = [
  { id: 1, href: "https://www.twitter.com", icon: "fab fa-facebook" },
  { id: 2, href: "https://www.twitter.com", icon: "fab fa-twitter" },
  { id: 3, href: "https://www.twitter.com", icon: "fab fa-squarespace" },
];

export const services = [
  {
    id: 1,
    icon: "fas fa-wallet fa-fw",
    title: "saving money",
    text: "Welcome to BackDrops, your go-to resource for budget-friendly travel tips and tricks. ",
  },
  {
    id: 2,
    icon: "fas fa-tree fa-fw",
    title: "endless hiking",
    text: "Embark on a journey of discovery with our endless hiking adventures.",
  },
  {
    id: 3,
    icon: "fas fa-socks fa-fw",
    title: "amazing comfort",
    text: "Experience unparalleled comfort and luxury on your next adventure with our Amazing Comfort tours",
  },
];

export const tours = [
  {
    id: 1,
    image: tour1,
    date: "august 26th, 2023",
    title: "Mustang Adventure",
    info: ` Mustang lies in the Northern part of Nepal beyond the Dhaulagiri and Annapurna Massifs. The rain shadow region, touching the end of the Tibetan plateau, is also popular as the last forbidden Kingdom as the place is highly restricted without the permit and once was an autonomous Kingdom.`,
    location: "Nepal",
    duration: 6,
    cost: 210,
  },
  {
    id: 2,
    image: tour2,
    date: "october 1th, 2023",
    title: "Annapurna Base Camp",
    info: `The Annapurna Base Camp trek is one of Nepal's most famous and classic hiking trips. It takes hikers deep into the mesmerizing Annapurna mountain range, all the way to the base camps of two massive peaks - Machhapuchhre at 6,993 meters tall and the very tall Annapurna I at over 8,091 meters.`,
    location: "Nepal",
    duration: 11,
    cost: 490,
  },
  {
    id: 3,
    image: tour3,
    date: "December 15th, 2023",
    title: "Explore Pokhara",
    info: `  With the magnificent Annapurna range forming the backdrop and the serenity of the Cluster of 9 Lakes with three major ones - Phewa, Rupa and Begnas – Pokhara is a great destination for a weekend getaway as well as a long relaxing holiday. `,
    location: "hong kong",
    duration: 8,
    cost: 300,
  },
];
