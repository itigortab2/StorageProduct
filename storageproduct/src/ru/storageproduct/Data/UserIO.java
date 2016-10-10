package ru.storageproduct.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ru.storageproduct.Model.User;

public class UserIO {

	public static void add(User user, String filepath)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.parse(filepath);

		Element root = document.getDocumentElement();

		Element u = document.createElement("user");

		Element login = document.createElement("login");
		login.appendChild(document.createTextNode(user.getLogin()));
		u.appendChild(login);

		Element password = document.createElement("password");
		password.appendChild(document.createTextNode(user.getPassword()));
		u.appendChild(password);

		Element email = document.createElement("email");
		email.appendChild(document.createTextNode(user.getEmail()));
		u.appendChild(email);

		Element permission = document.createElement("permission");
		permission.appendChild(document.createTextNode(user.getPermission()
				.toString()));
		u.appendChild(permission);

		root.appendChild(u);

		DOMSource source = new DOMSource(document);

		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		StreamResult result = new StreamResult(filepath);
		transformer.transform(source, result);
	}

	public static boolean findUser(String login, String filepath)
			throws IOException, ParserConfigurationException, SAXException {

		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		Document document = documentBuilder.parse(filepath);

		Node root = document.getDocumentElement();

		NodeList users = root.getChildNodes();

		boolean l = false;

		for (int i = 0; i < users.getLength(); i++) {

			Node user = users.item(i);

			if (user.getNodeType() != Node.TEXT_NODE) {
				NodeList userProps = user.getChildNodes();
				for (int j = 0; j < userProps.getLength(); j++) {
					Node userProp = userProps.item(j);
					if (userProp.getNodeType() != Node.TEXT_NODE) {
						if (userProp.getNodeName().equals("login")) {

							if (userProp.getChildNodes().item(0)
									.getTextContent().equals(login)) {

								return true;

							}
						}
					}
				}

			}
		}

		return false;

	}

	private static NodeList getNode(String filepath, String login) {

		try {

			DocumentBuilder documentBuilder = DocumentBuilderFactory
					.newInstance().newDocumentBuilder();

			Document document = documentBuilder.parse(filepath);

			Node root = document.getDocumentElement();

			NodeList users = root.getChildNodes();

			for (int i = 0; i < users.getLength(); i++) {

				Node user = users.item(i);

				if (user.getNodeType() != Node.TEXT_NODE) {

					NodeList userProps = user.getChildNodes();

					for (int j = 0; j < userProps.getLength(); j++) {

						Node userProp = userProps.item(j);

						if (userProp.getNodeType() != Node.TEXT_NODE) {

							if (userProp.getNodeName().equals("login")) {

								if (userProp.getChildNodes().item(0)
										.getTextContent().equals(login)) {

									return userProps;
								}

							}

						}
					}

				}
			}

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String getStringUser(String login, String filepath) {

		String lineuser = "";

		NodeList node = getNode(filepath, login);

		for (int j = 0; j < node.getLength(); j++) {
			Node userProp = node.item(j);
			if (userProp.getNodeType() != Node.TEXT_NODE) {

				lineuser += userProp.getChildNodes().item(0).getTextContent()
						+ "|";
			}
		}

		return lineuser;
	}

	public static boolean authUser(String login, String password,
			String filepath) throws IOException, ParserConfigurationException,
			SAXException {

		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		Document document = documentBuilder.parse(filepath);

		Node root = document.getDocumentElement();

		NodeList users = root.getChildNodes();

		boolean l = false;
		boolean p = false;

		for (int i = 0; i < users.getLength(); i++) {

			Node user = users.item(i);

			if (user.getNodeType() != Node.TEXT_NODE) {
				NodeList userProps = user.getChildNodes();
				for (int j = 0; j < userProps.getLength(); j++) {
					Node userProp = userProps.item(j);
					if (userProp.getNodeType() != Node.TEXT_NODE) {
						if (userProp.getNodeName().equals("login")) {
							if (userProp.getChildNodes().item(0)
									.getTextContent().equals(login)) {

								l = true;
							}

						}
						if (userProp.getNodeName().equals("password")) {
							if (userProp.getChildNodes().item(0)
									.getTextContent().equals(password)) {

								p = true;

							}

						}
					}
				}

				if (l == true && p == true)
					return true;
			}
		}

		return false;
	}

}
