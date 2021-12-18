package Prac15and16.GUI;

import Prac15and16.Customers.Address;
import Prac15and16.Customers.Customer;
import Prac15and16.Exceptions.EmptyOrderException;
import Prac15and16.Exceptions.IllegalTableNumberException;
import Prac15and16.Exceptions.OrderAlreadyAddedException;
import Prac15and16.Exceptions.WrongInputException;
import Prac15and16.Items.Dish;
import Prac15and16.Items.Drink;
import Prac15and16.Items.DrinkTypeEnum;
import Prac15and16.Orders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI extends JFrame {
    private JButton buttonInternetOrder = new JButton("Заказать через интернет");
    private JButton buttonRestaurantOrder = new JButton("Заказать в ресторане");
    private JButton buttonReadOrders = new JButton("Вывести список заказов");
    private JLabel label = new JLabel("Добро пожаловать!");
    protected TableOrdersManager tableOrdersManager = new TableOrdersManager(20);
    protected InternetOrdersManager internetOrdersManager = new InternetOrdersManager();

    String[] drinkChoices = {
            "BEER",
            "WINE",
            "VODKA",
            "BRANDY",
            "CHAMPAGNE",
            "WHISKEY",
            "TEQUILA",
            "RUM",
            "VERMUTH",
            "LIQUOR",
            "JAGERMEISTER",
            "JUICE",
            "COFFEE",
            "GREEN_TEA",
            "BLACK_TEA",
            "MILK",
            "WATER",
            "SODA"
    };


    public GUI(){
        setSize(240,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ресторан");

        Container form = this.getContentPane();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonInternetOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonRestaurantOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonReadOrders.setAlignmentX(Component.CENTER_ALIGNMENT);

        form.add(Box.createRigidArea(new Dimension(20, 30)));
        form.add(label);
        form.add(Box.createRigidArea(new Dimension(20, 30)));
        form.add(buttonInternetOrder);
        form.add(Box.createRigidArea(new Dimension(20, 30)));
        form.add(buttonRestaurantOrder);
        form.add(Box.createRigidArea(new Dimension(20, 30)));
        form.add(buttonReadOrders);
        form.add(Box.createRigidArea(new Dimension(20, 30)));

        buttonInternetOrder.addActionListener(new ButtonEvent1());
        buttonReadOrders.addActionListener(new ButtonEvent3());
        buttonRestaurantOrder.addActionListener(new ButtonEvent2());
    }

    class ButtonEvent1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            internetOrderFrame secondFrame = new internetOrderFrame();
        }
    }

    class ButtonEvent2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            restaurantOrderFrame thirdFrame = new restaurantOrderFrame();
        }
    }

    class ButtonEvent3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,internetOrdersManager.readAddressedOrders()
                    + "\n" + tableOrdersManager.readOrders(),"Список заказов", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class internetOrderFrame extends JFrame {
        private JLabel frameTitle = new JLabel("Внесение адресса: ");
        private JTextField cityName = new JTextField("",5);
        private JLabel cityNameLabel = new JLabel("Название города: ");
        private JTextField zipCode = new JTextField("",5);
        private JLabel zipCodeLabel = new JLabel("Зип код: ");
        private JTextField streetName = new JTextField("",5);
        private JLabel streetNameLabel = new JLabel("Название улицы: ");
        private JTextField buildingNumber = new JTextField("",5);
        private JLabel buildNumberLabel = new JLabel("Номер дома: ");
        private JTextField buildingLetter = new JTextField("",5);
        private JLabel buildingLetterLabel = new JLabel("Буква дома: ");
        private JTextField apartmentNumber = new JTextField("",5);
        private JLabel apartmentNumberLabel = new JLabel("Номер квартиры: ");
        private JButton addAddress = new JButton("Ввод адресса");

        public Address address;

        public internetOrderFrame(){
            setVisible(true);
            setTitle("Окно интернет заказа");
            setSize(400,320);

            Container form = this.getContentPane();
            form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
            form.add(frameTitle);
            form.add(Box.createRigidArea(new Dimension(20, 30)));

            Box box1 = Box.createHorizontalBox();
            box1.add(cityNameLabel);
            box1.add(cityName);
            form.add(box1);

            Box box2 = Box.createHorizontalBox();
            box2.add(zipCodeLabel);
            box2.add(zipCode);
            form.add(box2);

            Box box3 = Box.createHorizontalBox();
            box3.add(streetNameLabel);
            box3.add(streetName);
            form.add(box3);

            Box box4 = Box.createHorizontalBox();
            box4.add(buildNumberLabel);
            box4.add(buildingNumber);
            form.add(box4);

            Box box5 = Box.createHorizontalBox();
            box5.add(buildingLetterLabel);
            box5.add(buildingLetter);
            form.add(box5);

            Box box6 = Box.createHorizontalBox();
            box6.add(apartmentNumberLabel);
            box6.add(apartmentNumber);
            form.add(box6);

            form.add(Box.createRigidArea(new Dimension(20, 30)));

            addAddress.addActionListener(new ButtonEvent1());
            form.add(addAddress);
        }

        class ButtonEvent1 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try {
                    if(cityName.getText().length() == 0 ||
                       zipCode.getText().length() == 0 ||
                       streetName.getText().length() == 0 ||
                       buildingNumber.getText().length() == 0 ||
                       buildingLetter.getText().length() == 0 ||
                       apartmentNumber.getText().length() == 0){
                        throw new WrongInputException("Заполните все поля");
                    }
                    if(!zipCode.getText().matches("^[0-9]+$") ||
                            !buildingNumber.getText().matches("^[0-9]+$") ||
                            !apartmentNumber.getText().matches("^[0-9]+$")){
                        throw new WrongInputException("Неправильный ввод чисел");
                    }
                    address = new Address(cityName.getText(), Integer.parseInt(zipCode.getText()), streetName.getText(),
                            Integer.parseInt(buildingNumber.getText()), buildingLetter.getText().charAt(0),
                            Integer.parseInt(apartmentNumber.getText()));
                    JOptionPane.showMessageDialog(null, "Адресс: " + address.getCityName() + " "
                            + address.getZipCode() + " " + address.getStreetName() + " " + address.getBuildingNumber() +
                            " " + address.getApartmentNumber() + "\n           Успешно добавлен!", "Успех!", JOptionPane.PLAIN_MESSAGE);
                    clientEntering fourthFrame = new clientEntering();
                    setVisible(false);
                }
                catch (WrongInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }

        class clientEntering extends JFrame {
            private JLabel title = new JLabel("Внесите данные клиента: ");
            private JTextField firstName = new JTextField("",5);
            private JLabel firstNameLabel = new JLabel("Введите имя клиента: ");
            private JTextField secondName = new JTextField("",5);
            private JLabel secondNameLabel = new JLabel("Введите фимилию клиента: ");
            private JTextField age = new JTextField("",5);
            private JLabel ageLabel = new JLabel("Введите возраст клиента: ");
            private JButton addClient = new JButton("Внести информаию о клиенте");
            private Customer customer;

            public clientEntering(){
                setVisible(true);
                setTitle("Окно ввода информации о клиенте");
                setSize(400,240);

                Container form = this.getContentPane();
                form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

                form.add(frameTitle);

                form.add(Box.createRigidArea(new Dimension(20, 30)));

                Box box1 = Box.createHorizontalBox();
                box1.add(firstNameLabel);
                box1.add(firstName);
                form.add(box1);

                Box box2 = Box.createHorizontalBox();
                box2.add(secondNameLabel);
                box2.add(secondName);
                form.add(box2);

                Box box3 = Box.createHorizontalBox();
                box3.add(ageLabel);
                box3.add(age);
                form.add(box3);

                form.add(Box.createRigidArea(new Dimension(20, 30)));

                addClient.addActionListener(new ButtonEvent2());
                form.add(addClient);

                form.add(Box.createRigidArea(new Dimension(20, 30)));
            }

            class ButtonEvent2 implements ActionListener{
                public void actionPerformed(ActionEvent e){
                    try {
                        if(firstName.getText().length() == 0 ||
                                secondName.getText().length() == 0 ||
                                age.getText().length() == 0){
                            throw new WrongInputException("Заполните все поля");
                        }
                        if(!age.getText().matches("^[0-9]+$")){
                            throw new WrongInputException("Неправильный ввод чисел");
                        }
                        customer = new Customer(firstName.getText(), secondName.getText(),
                                Integer.parseInt(age.getText()), address);
                        JOptionPane.showMessageDialog(null, "Данные клиента: "
                                + customer.getFirstName() + " " + customer.getSecondName() + " " + customer.getAge() +
                                "\n           Успешно внесены!", "Успех!", JOptionPane.PLAIN_MESSAGE);
                        AddingOrder fourthFrame = new AddingOrder();
                        setVisible(false);
                    }
                    catch (WrongInputException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage(),
                                "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                    }
                }

            }

            class AddingOrder extends JFrame{
                private JLabel title = new JLabel("Внесите данные о блюде: ");
                private JTextField dishName = new JTextField("",5);
                private JLabel dishNameLabel = new JLabel("Введите название блюда: ");
                private JTextField dishDescription = new JTextField("",5);
                private JLabel dishDescriptionLabel = new JLabel("Введите описание блюда: ");
                private JTextField dishPrice = new JTextField("",5);
                private JLabel dishPriceLabel = new JLabel("Введите цену блюда: ");
                private JButton addDish = new JButton("Внести блюдо в заказ");

                private JLabel title1 = new JLabel("Внесите данных о напитке: ");
                private JComboBox<String> drinkType = new JComboBox<String>(drinkChoices);
                private JTextField drinkPrice = new JTextField("",5);
                private JLabel drinkPriceLabel = new JLabel("Введите цену напитка: ");
                private JButton addDrink = new JButton("Внести напиток в заказ");


                private JButton finishOrder = new JButton("Закончить ввод заказа");

                Order order = new InternetOrder();

                public AddingOrder(){
                    setVisible(true);
                    setTitle("Окно внесения заказа");
                    setSize(720, 260);

                    Container form = this.getContentPane();
                    form.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    form.setLayout(new GridBagLayout());

                    GridBagConstraints constraints = new GridBagConstraints();

                    constraints.weightx = 1.5;
                    constraints.weighty = 0.5;

                    constraints.gridx = 0;
                    constraints.fill = GridBagConstraints.HORIZONTAL;
                    form.add(title1, constraints);
                    constraints.gridy = 1;
                    constraints.gridx = 0;
                    form.add(drinkType, constraints);

                    constraints.gridy = 3;

                    constraints.gridx = 0;
                    form.add(drinkPriceLabel, constraints);
                    constraints.gridx = 1;
                    form.add(drinkPrice, constraints);

                    constraints.gridy = 4;
                    constraints.gridx = 1;
                    constraints.fill = GridBagConstraints.CENTER;
                    addDrink.addActionListener(new ButtonEvent3());
                    form.add(addDrink,constraints);

                    constraints.gridx = 2;
                    constraints.gridy = 0;
                    constraints.fill = GridBagConstraints.HORIZONTAL;
                    form.add(title, constraints);

                    constraints.gridy = 1;
                    constraints.gridx = 2;
                    form.add(dishNameLabel, constraints);
                    constraints.gridx = 3;
                    form.add(dishName, constraints);

                    constraints.gridy = 2;

                    constraints.gridx = 2;
                    form.add(dishDescriptionLabel, constraints);
                    constraints.gridx = 3;
                    form.add(dishDescription, constraints);

                    constraints.gridy = 3;

                    constraints.gridx = 2;
                    form.add(dishPriceLabel, constraints);
                    constraints.gridx = 3;
                    form.add(dishPrice, constraints);

                    constraints.gridy = 4;
                    constraints.gridx = 3;
                    constraints.fill = GridBagConstraints.CENTER;
                    addDish.addActionListener(new ButtonEvent4());
                    form.add(addDish, constraints);

                    constraints.gridy = 4;
                    constraints.gridx = 2;
                    finishOrder.addActionListener(new ButtonEvent5());
                    form.add(finishOrder, constraints);
                }

                class ButtonEvent3 implements ActionListener{
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(!drinkPrice.getText().matches("^[0-9]+$") || drinkPrice.getText().length() == 0){
                                throw new WrongInputException("Неправильный ввод чисел");
                            }
                            Drink drink = new Drink(String.valueOf(drinkType.getSelectedItem()), String.valueOf(drinkType.getSelectedItem()),
                                    Integer.parseInt(drinkPrice.getText()), DrinkTypeEnum.valueOf(String.valueOf(drinkType.getSelectedItem())));
                            JOptionPane.showMessageDialog(null, "Данные напитка: " + drink.getName()
                                    + " " + drink.getDescription() + " " + drink.getPrice() +
                                    "\n           Успешно внесены!", "Успех!", JOptionPane.PLAIN_MESSAGE);
                            order.add(drink);
                        }
                        catch (WrongInputException ex){
                            JOptionPane.showMessageDialog(null, ex.getMessage(),
                                    "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }

                class ButtonEvent4 implements ActionListener{
                    public void actionPerformed(ActionEvent e){
                        try {
                            if(dishName.getText().length() == 0 ||
                                    dishDescription.getText().length() == 0 ||
                                    dishPrice.getText().length() == 0){
                                throw new WrongInputException("Заполните все поля");
                            }
                            if(!dishPrice.getText().matches("^[0-9]+$")){
                                throw new WrongInputException("Неправильный ввод чисел");
                            }
                            Dish dish = new Dish(dishName.getText(), dishDescription.getText(),
                                    Integer.parseInt(dishPrice.getText()));
                            JOptionPane.showMessageDialog(null, "Данные блюда: " + dish.getName()
                                    + " " + dish.getDescription() + " " + dish.getPrice()
                                    + "\n           Успешно внесены!", "Успех!", JOptionPane.PLAIN_MESSAGE);
                            order.add(dish);
                        }
                        catch (WrongInputException ex){
                            JOptionPane.showMessageDialog(null, ex.getMessage(),
                                    "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }

                class ButtonEvent5 implements ActionListener{
                    public void actionPerformed(ActionEvent e){
                        try {
                            String itemNames = Arrays.toString(order.itemsNames());
                            if (itemNames.substring(1, itemNames.length() - 1).length() == 0)
                                throw new EmptyOrderException("Вы не выбрали ни одного блюда или напитка");
                            JOptionPane.showMessageDialog(null, "Внесенные блюда в заказ: "
                                            + itemNames.substring(1, itemNames.length() - 1),
                                    "Заказ успешно внесен!", JOptionPane.PLAIN_MESSAGE);
                            internetOrdersManager.add(customer, order);
                            setVisible(false);
                        }
                        catch (EmptyOrderException ex){
                            JOptionPane.showMessageDialog(null, ex.getMessage(),
                                    "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }
            }
        }
    }

    class restaurantOrderFrame extends JFrame {

        private JLabel title = new JLabel("Внесите данных о блюде: ");
        private JTextField dishName = new JTextField("",5);
        private JLabel dishNameLabel = new JLabel("Введите название блюда: ");
        private JTextField dishDescription = new JTextField("",5);
        private JLabel dishDescriptionLabel = new JLabel("Введите описание блюда: ");
        private JTextField dishPrice = new JTextField("",5);
        private JLabel dishPriceLabel = new JLabel("Введите цену блюда: ");
        private JButton addDish = new JButton("Ввести блюдо в заказ");

        private JLabel title1 = new JLabel("Внесите данных о напитке: ");
        private JComboBox<String> drinkType = new JComboBox<String>(drinkChoices);
        private JTextField drinkPrice = new JTextField("",5);
        private JLabel drinkPriceLabel = new JLabel("Введите цену напитка: ");
        private JButton addDrink = new JButton("Ввести напиток в заказ");

        private JLabel tableNumberLable = new JLabel("Введите номер столика: ");
        private JTextField tableNumber = new JTextField("", 5);
        private JButton finishOrder = new JButton("Закончить ввод заказа");

        Order order = new RestaurantOrder();

        public restaurantOrderFrame(){
                setVisible(true);
                setTitle("Окно внесения заказа");
                setSize(820, 260);

                Container form = this.getContentPane();
                form.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                form.setLayout(new GridBagLayout());

                GridBagConstraints constraints = new GridBagConstraints();

                constraints.weightx = 1.5;
                constraints.weighty = 0.5;

                constraints.gridx = 0;
                constraints.fill = GridBagConstraints.HORIZONTAL;
                form.add(title1, constraints);
                constraints.gridy = 1;
                constraints.gridx = 0;
                form.add(drinkType, constraints);

                constraints.gridy = 3;

                constraints.gridx = 0;
                form.add(drinkPriceLabel, constraints);
                constraints.gridx = 1;
                form.add(drinkPrice, constraints);

                constraints.gridy = 4;
                constraints.gridx = 1;
                addDrink.addActionListener(new ButtonEvent3());
                form.add(addDrink, constraints);

                constraints.gridx = 2;
                constraints.gridy = 0;
                form.add(title, constraints);

                constraints.gridy = 1;
                constraints.gridx = 2;
                form.add(dishNameLabel, constraints);
                constraints.gridx = 3;
                form.add(dishName, constraints);

                constraints.gridy = 2;

                constraints.gridx = 2;
                form.add(dishDescriptionLabel, constraints);
                constraints.gridx = 3;
                form.add(dishDescription, constraints);

                constraints.gridy = 3;

                constraints.gridx = 2;
                form.add(dishPriceLabel, constraints);
                constraints.gridx = 3;
                form.add(dishPrice, constraints);

                constraints.gridy = 4;
                constraints.gridx = 3;
                addDish.addActionListener(new ButtonEvent4());
                form.add(addDish, constraints);


                constraints.gridy = 5;
                constraints.gridx = 0;
                form.add(tableNumberLable, constraints);

                constraints.gridy = 5;
                constraints.gridx = 1;
                form.add(tableNumber, constraints);

                constraints.gridy = 5;
                constraints.gridx = 3;
                finishOrder.addActionListener(new ButtonEvent5());
                form.add(finishOrder, constraints);
        }

        class ButtonEvent3 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                    if(!drinkPrice.getText().matches("^[0-9]+$") || drinkPrice.getText().length() == 0){
                        throw new WrongInputException("Неправильный ввод чисел");
                    }
                    Drink drink = new Drink(String.valueOf(drinkType.getSelectedItem()), String.valueOf(drinkType.getSelectedItem()),
                            Integer.parseInt(drinkPrice.getText()), DrinkTypeEnum.valueOf(String.valueOf(drinkType.getSelectedItem())));
                    JOptionPane.showMessageDialog(null, "Данные напитка: " + drink.getName()
                            + " " + drink.getDescription() + " " + drink.getPrice() +
                            "\n           Успешно внесены!", "Успех!", JOptionPane.PLAIN_MESSAGE);
                    order.add(drink);
                }
                catch (WrongInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }

        class ButtonEvent4 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try {
                    if(dishName.getText().length() == 0 ||
                            dishDescription.getText().length() == 0 ||
                            dishPrice.getText().length() == 0){
                        throw new WrongInputException("Заполните все поля");
                    }
                    if(!dishPrice.getText().matches("^[0-9]+$")){
                        throw new WrongInputException("Неправильный ввод чисел");
                    }
                    Dish dish = new Dish(dishName.getText(), dishDescription.getText(),
                            Integer.parseInt(dishPrice.getText()));
                    JOptionPane.showMessageDialog(null, "Данные блюда: " + dish.getName()
                            + " " + dish.getDescription() + " " + dish.getPrice()
                            + "\n           Успешно внесены!", "Успех!", JOptionPane.PLAIN_MESSAGE);
                    order.add(dish);
                }
                catch (WrongInputException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }

        class ButtonEvent5 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try {
                    String itemNames = Arrays.toString(order.itemsNames());
                    if(itemNames.substring(1, itemNames.length() - 1).length() == 0)
                        throw new EmptyOrderException("Вы не выбрали ни одного блюда или напитка");
                    tableOrdersManager.add(order,Integer.parseInt(tableNumber.getText()));
                    JOptionPane.showMessageDialog(null,"Внесенные блюда в заказ: "
                            + itemNames.substring(1, itemNames.length() - 1), "Заказ успешно внесен!"
                            ,JOptionPane.PLAIN_MESSAGE);
                    setVisible(false);
                } catch (OrderAlreadyAddedException | IllegalTableNumberException | EmptyOrderException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Ошибка!", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }
}
