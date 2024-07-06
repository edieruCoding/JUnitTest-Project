package com.example.shoppingcart.test;

import com.example.shoppingcart.Product;
import com.example.shoppingcart.ShoppingCart;
import org.junit.*;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    private static Product product1;
    private static Product product2;
    private ShoppingCart cart;
 
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        product1 = new Product("Laptop", 999.99);
        product2 = new Product("Smartphone", 599.99);
        System.out.println("Executed once before any test methods in this class.");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        product1 = null;
        product2 = null;
        System.out.println("Executed once after all test methods in this class.");
    }

    @Before
    public void setUp() throws Exception {
        cart = new ShoppingCart();
        System.out.println("Executed before each test method in this class.");
    }

    @After
    public void tearDown() throws Exception {
        cart = null;
        System.out.println("Executed after each test method in this class.");
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        assertEquals(1, cart.getProductCount());
        assertEquals(999.99, cart.getTotalPrice(), 0.01);
        System.out.println("Executed testAddProduct method.");
    }
    
    @Test
    public void testAddProduct2() {
        cart.addProduct(product1);
        assertEquals(1, cart.getProductCount());
        assertEquals(999.99, cart.getTotalPrice(), 0.01);
        System.out.println("Executed testAddProduct method.");
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);
        assertEquals(1, cart.getProductCount());
        assertEquals(599.99, cart.getTotalPrice(), 0.01);
        System.out.println("Executed testRemoveProduct method.");
    }

    @Test
    public void testGetTotalPrice() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(1599.98, cart.getTotalPrice(), 0.01);
        System.out.println("Executed testGetTotalPrice method.");
    }

    @Test
    public void testClearCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.clearCart();
        assertEquals(0, cart.getProductCount());
        assertEquals(0.0, cart.getTotalPrice(), 0.01);
        System.out.println("Executed testClearCart method.");
    }
}
