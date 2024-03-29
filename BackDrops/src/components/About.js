import aboutImg from "../images/about.jpeg";
import Title from "./Title";

const About = () => {
  return (
    <section className="section" id="about">
      <Title title="about" subTitle="us" />

      <div className="section-center about-center">
        <div className="about-img">
          <img src={aboutImg} className="about-photo" alt="awesome beach" />
        </div>
        <article className="about-info">
          <h3>Travel with us</h3>
          <p>
            Welcome to BackDrpos, your premier destination for unforgettable
            travel experiences. At BackDrpos, we believe that travel is not just
            about reaching a destination; it's about the journey itself. With a
            passion for exploration and a commitment to excellence, we curate
            extraordinary travel experiences that exceed your expectations.
          </p>
          <p>
            Our mission at BackDrpos tours and trevels is to inspire and empower
            travelers to embark on enriching journeys that create lasting
            memories. We strive to provide personalized service, attention to
            detail, and unparalleled expertise to ensure every trip is seamless
            and unforgettable.
          </p>
          <a href="#" className="btn">
            read more
          </a>
        </article>
      </div>
    </section>
  );
};
export default About;
