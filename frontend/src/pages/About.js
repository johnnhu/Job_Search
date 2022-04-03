import Layout from "../layout/Layout";

const About = () => {
  return (
    <Layout title={"About"}>
      <p>
        Our CPSC 304 project! Learn more at{" "}
        <a
          rel="noreferrer"
          target="_blank"
          href="https://github.com/emilyychenn/jSearch"
        >
          this link
        </a>
        .
      </p>
    </Layout>
  );
};

export default About;
