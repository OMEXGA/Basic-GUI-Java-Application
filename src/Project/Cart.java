/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author aladin
 */
public class Cart extends javax.swing.JFrame {
private static final java.util.Map<String, java.util.List<CartItem>> userCarts = new java.util.HashMap<>();


    private void updateOrderNumberLabel() {
        String currentUserEmail = Project.Loginnew.loggedInUserEmail;

        if (currentUserEmail != null) {
            int nextOrderId = OrderDataBase.getNextOrderId(currentUserEmail);

            jLabel11.setText(String.valueOf(nextOrderId)); 
        } else {
            jLabel11.setText("-"); 
        }
    }

    private void addPlaceholderStyle(javax.swing.JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(java.awt.Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(java.awt.Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(java.awt.Color.GRAY);
                }
            }
        });
    }
    private void addPlaceholderStyle(javax.swing.JTextArea textArea, String placeholder) {
        textArea.setText(placeholder);
        textArea.setForeground(java.awt.Color.GRAY);

        textArea.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textArea.getText().equals(placeholder)) {
                    textArea.setText("");
                    textArea.setForeground(java.awt.Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (textArea.getText().isEmpty()) {
                    textArea.setText(placeholder);
                    textArea.setForeground(java.awt.Color.GRAY);
                }
            }
        });
    }

    private void updatePaymentFieldsState() {

        
        boolean isCreditCardSelected = jRadioButton6.isSelected(); 


        jTextField4.setEnabled(isCreditCardSelected); 
        jTextField5.setEnabled(isCreditCardSelected);
        jTextField6.setEnabled(isCreditCardSelected); 
        jTextField7.setEnabled(isCreditCardSelected); 
    }

    private static java.util.List<CartItem> getCurrentUserCart() {
        String currentUser = Project.Loginnew.loggedInUserEmail;
        if (currentUser == null) {
            return new java.util.ArrayList<>(); 
        }
        userCarts.putIfAbsent(currentUser, new java.util.ArrayList<>());
        return userCarts.get(currentUser);
    }
    private static void saveCurrentUserCartToFile() {
        String currentUser = Project.Loginnew.loggedInUserEmail;
        if (currentUser != null) {
            CartDataBase.saveCart(currentUser, getCurrentUserCart());
        }
    }

    public static void addItem(CartItem newItem) {
        java.util.List<CartItem> currentUserCart = getCurrentUserCart();
        for (CartItem item : currentUserCart) {
            if (item.getName().equals(newItem.getName()) && item.getSize().equals(newItem.getSize())) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                saveCurrentUserCartToFile(); 
                return;
            }
        }
        currentUserCart.add(newItem);
        saveCurrentUserCartToFile();
    }
    


    public static void removeItem(CartItem itemToRemove) {
        getCurrentUserCart().remove(itemToRemove);
        saveCurrentUserCartToFile(); 
    }


        public static java.util.List<CartItem> getItems() {
            return getCurrentUserCart();
        }


        public static double calculateSubtotal() {
            double subtotal = 0.0;
            for (CartItem item : getCurrentUserCart()) {
                subtotal += item.getPrice() * item.getQuantity();
            }
            return subtotal;
        }


        public static void clearCurrentUserCart() {
            getCurrentUserCart().clear();
            saveCurrentUserCartToFile();
        }
    public Cart() {
        initComponents();
        java.awt.event.ActionListener paymentListener = e -> updatePaymentFieldsState();
        
        addPlaceholderStyle(jTextField1, "Recipient Name");
        addPlaceholderStyle(jTextArea1, "Address"); 
        addPlaceholderStyle(jTextField3, "Phone Number");
        addPlaceholderStyle(jTextField9, "Country"); 
        addPlaceholderStyle(jTextField8, "City or Province"); 
        addPlaceholderStyle(jTextField10, "Postal Number");
        
        // Payment Details
        addPlaceholderStyle(jTextField4, "Cardholder Name");
        addPlaceholderStyle(jTextField5, "Card Number");     
        addPlaceholderStyle(jTextField6, "Expiration Date (MM/YY)"); 
        addPlaceholderStyle(jTextField7, "CVV");  
        
        jRadioButton4.addActionListener(paymentListener); 
        jRadioButton6.addActionListener(paymentListener); 

        updatePaymentFieldsState();
        

        jScrollPane2.setPreferredSize(new java.awt.Dimension(jScrollPane2.getWidth(), 200));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 200));
        
        updateOrderNumberLabel();
        loadCartItems();
        jComboBox1.addActionListener(e -> updateTotals());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Adelle Sans Devanagari", 0, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 0, 51));
        jRadioButton4.setText("Payment on delivery");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Adelle Sans Devanagari", 0, 14)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(255, 0, 51));
        jRadioButton6.setText("Credit card");
        jRadioButton6.setToolTipText("");

        jTextField4.setForeground(new java.awt.Color(255, 0, 51));
        jTextField4.setText("Cardholder Name");

        jTextField5.setForeground(new java.awt.Color(255, 0, 51));
        jTextField5.setText("Card Number");

        jTextField6.setForeground(new java.awt.Color(255, 0, 51));
        jTextField6.setText("Expiration Date(MM/YY)");
        jTextField6.setToolTipText("");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setForeground(new java.awt.Color(255, 0, 51));
        jTextField7.setText("CVV");

        jLabel10.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Payment");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton6)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Shipping Details");

        jTextField1.setForeground(new java.awt.Color(255, 0, 51));
        jTextField1.setText("Recipient Name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.setForeground(new java.awt.Color(255, 0, 51));
        jTextField3.setText("Phone Number");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField10.setForeground(new java.awt.Color(255, 0, 51));
        jTextField10.setText("Postal Number");
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTextField9.setForeground(new java.awt.Color(255, 0, 51));
        jTextField9.setText("Country");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField8.setForeground(new java.awt.Color(255, 0, 51));
        jTextField8.setText("CIty or Province");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 0, 51));
        jTextArea1.setRows(5);
        jTextArea1.setText("Address");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(jTextField3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 14)); // NOI18N
        jButton1.setText("Confirm Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Adelle Sans Devanagari", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 51));
        jButton4.setText("Profile");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setForeground(new java.awt.Color(255, 0, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Promotion", "10% Off All Jeans (Once per account)", "Buy 2 Items, Get 1 Free (Once per account)" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Total:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("100฿");

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Total orders:");

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Discount:");

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("100฿");

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("100฿");

        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("-");

        jLabel15.setText("Product Name:");

        jLabel16.setText("Size:");

        jLabel17.setText("Price:");

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton12.setText("Delete");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(407, 407, 407)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1))
                .addGap(13, 13, 13))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton12)))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel7);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jButton6.setText("┇");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setForeground(new java.awt.Color(255, 0, 51));
        jButton8.setText("< Main Menu");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Order Number:");

        jLabel11.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("001");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton8)
                        .addGap(627, 627, 627)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3))
                                                .addGap(25, 25, 25)))
                                        .addGap(76, 76, 76)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel7)))
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jButton1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jButton8))
                .addGap(13, 13, 13)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

// --- 1. VALIDATION (This part is unchanged) ---
    String recipientName = jTextField1.getText();
    String address = jTextArea1.getText();
    String phoneNumber = jTextField3.getText();
    String country = jTextField9.getText();
    String city = jTextField8.getText();
    String postal = jTextField10.getText();

    if (recipientName.isEmpty() || recipientName.equals("Recipient Name") ||
        address.isEmpty() || address.equals("Address") ||
        phoneNumber.isEmpty() || phoneNumber.equals("Phone Number") ||
        country.isEmpty() || country.equals("Country") ||
        city.isEmpty() || city.equals("CIty or Province") || 
        postal.isEmpty() || postal.equals("Postal Number")) {
        JOptionPane.showMessageDialog(this, "Please fill in all required shipping details.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!jRadioButton4.isSelected() && !jRadioButton6.isSelected()) {
        JOptionPane.showMessageDialog(this, "Please select a payment method.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (jRadioButton6.isSelected()) {
        String cardHolder = jTextField4.getText();
        String cardNumber = jTextField5.getText();
        String ex_date = jTextField6.getText();
        String cvv = jTextField7.getText();
        if (cardHolder.isEmpty() || cardHolder.equals("Cardholder Name") ||
            cardNumber.isEmpty() || cardNumber.equals("Card Number") ||
            ex_date.isEmpty() || ex_date.equals("Expiration Date(MM/YY)") ||
            cvv.isEmpty() || cvv.equals("CVV")) {
            JOptionPane.showMessageDialog(this, "Please fill in all required credit card details.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // --- 2. PRICE CALCULATION (This is the new/modified part) ---
    String selectedPromoName = (String) jComboBox1.getSelectedItem();
    String currentUserEmail = Project.Loginnew.loggedInUserEmail;

    // First, calculate the original subtotal from all items in the cart
    double subtotal = 0.0;
    for (CartItem item : Cart.getItems()) {
        subtotal += item.getPrice() * item.getQuantity();
    }
    
    // Initialize finalTotal. It will be changed if a valid promo is applied.
    double finalTotal = subtotal;

    // Now, check the promotions and adjust the finalTotal if applicable
    if ("10% Off All Jeans (Once per account)".equals(selectedPromoName)) {
        if (PromotionDataBase.hasUserUsedPromo(currentUserEmail, "JEANS_10_PERCENT")) {
            JOptionPane.showMessageDialog(this, "You have already used this promotion.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean hasJeans = false;
        for (CartItem item : Cart.getItems()) {
            ProductData product = ProductDataBase.getProductByName(item.getName());
            if (product != null && "Jean".equalsIgnoreCase(product.getCategory())) {
                hasJeans = true;
                break;
            }
        }
        if (hasJeans) {
            // APPLY THE 10% DISCOUNT
            finalTotal = subtotal * 0.90;
        } else {
             JOptionPane.showMessageDialog(this, "You do not have any jeans for this promotion.", "Validation Error", JOptionPane.ERROR_MESSAGE);
             return;
        }
    } else if ("Buy 2 Items, Get 1 Free (Once per account)".equals(selectedPromoName)) {
        if (PromotionDataBase.hasUserUsedPromo(currentUserEmail, "BUY_2_GET_1_FREE")) {
            JOptionPane.showMessageDialog(this, "You have already used this promotion.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int totalQuantity = Cart.getItems().stream().mapToInt(CartItem::getQuantity).sum();
        if (totalQuantity >= 2) {
            // Find the cheapest item in the cart
            CartItem cheapestItem = null;
            double minPrice = Double.MAX_VALUE;
            for (CartItem item : Cart.getItems()) {
                if (item.getPrice() < minPrice) {
                    minPrice = item.getPrice();
                    cheapestItem = item;
                }
            }
            // APPLY THE DISCOUNT by subtracting the cheapest item's price
            if (cheapestItem != null) {
                finalTotal = subtotal - cheapestItem.getPrice();
            }
        } else {
            JOptionPane.showMessageDialog(this, "You do not have enough items for this promotion.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // --- 3. SAVE THE ORDER (This part now uses the calculated finalTotal) ---
    int nextOrderId = OrderDataBase.getNextOrderId(currentUserEmail); 
    String shippingInfo = String.join(" | ", recipientName, phoneNumber, address, country, city, postal);
    
    String paymentInfo;
    if (jRadioButton4.isSelected()) { 
        paymentInfo = "Payment on delivery";
    } else {
        paymentInfo = String.join(" | ", 
            "Credit Card",
            jTextField4.getText(),
            jTextField5.getText(),
            jTextField6.getText(),
            jTextField7.getText()
        );
    }
    String promotionUsed = (String) jComboBox1.getSelectedItem();

    // We use our newly calculated 'finalTotal' variable here, NOT the text from the label
    OrderDataBase.saveOrder(nextOrderId, currentUserEmail, Cart.getItems(), shippingInfo, finalTotal, paymentInfo, promotionUsed);

    // --- 4. FINISH UP (This part is unchanged) ---
    String promoCodeToRecord = null;
    if ("10% Off All Jeans (Once per account)".equals(selectedPromoName)) {
        promoCodeToRecord = "JEANS_10_PERCENT";
    } else if ("Buy 2 Items, Get 1 Free (Once per account)".equals(selectedPromoName)) {
        promoCodeToRecord = "BUY_2_GET_1_FREE";
    }
    if (promoCodeToRecord != null) {
        PromotionDataBase.recordPromoUsage(currentUserEmail, promoCodeToRecord); 
    }

    Cart.clearCurrentUserCart();
    loadCartItems();
    JOptionPane.showMessageDialog(this, "Order #" + nextOrderId + " confirmed successfully!" + "Thank You!!!!");
    MainMenu mainMenu = new MainMenu();
    mainMenu.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    javax.swing.JPopupMenu popupMenu = new javax.swing.JPopupMenu();

    javax.swing.JMenuItem historyItem = new javax.swing.JMenuItem("Order History");
    javax.swing.JMenuItem reportItem = new javax.swing.JMenuItem("Report");

    popupMenu.add(historyItem);
    popupMenu.add(reportItem );
    popupMenu.add(new javax.swing.JPopupMenu.Separator()); // This adds the line


    historyItem.addActionListener(e -> {
        if (Project.Loginnew.userIsLoggedIn) {
        System.out.println("Order History clicked"); 
        History history = new History();
        history.setVisible(true);
        this.dispose();
        }else {
        javax.swing.JOptionPane.showMessageDialog(this, "Please log in to access Order History.");
    }
    });

    reportItem.addActionListener(e -> {
        Report report = new Report();
        report.setVisible(true);
        this.dispose();
        System.out.println("Report clicked");
    });

if (Project.Loginnew.userIsLoggedIn) {
        popupMenu.add(new javax.swing.JPopupMenu.Separator());
        javax.swing.JMenuItem logoutItem = new javax.swing.JMenuItem("Logout");
        popupMenu.add(logoutItem);
        logoutItem.addActionListener(e -> {
            int response = javax.swing.JOptionPane.showConfirmDialog(this,
                "Are you sure you want to log out?", "Confirm Logout",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE);

            if (response == javax.swing.JOptionPane.YES_OPTION) {
                Cart.clearCurrentUserCart();
                Project.Loginnew.userIsLoggedIn = false;
                Project.Loginnew.loggedInUserEmail = null;
                new Project.Loginnew().setVisible(true);
                this.dispose();
            }
        });
    }


    popupMenu.show(jButton6, 0, jButton6.getHeight());

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Profile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Cart().setVisible(true);
            }
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
    }

    private static final java.text.DecimalFormat df = new java.text.DecimalFormat("0.00฿");

    private void loadCartItems() {
        jPanel7.removeAll(); 
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        java.util.List<CartItem> cartItems = Cart.getItems();

        if (cartItems.isEmpty()) {
        javax.swing.JLabel emptyLabel = new javax.swing.JLabel("Your cart is empty.");
        emptyLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        emptyLabel.setForeground(java.awt.Color.RED);
        jPanel7.add(emptyLabel);
        } else {
            for (CartItem item : cartItems) {
                jPanel7.add(createCartItemPanel(item));
                jPanel7.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
            }
        }
        
        updateTotals(); 
        jPanel7.revalidate();
        jPanel7.repaint();
        updateOrderNumberLabel();
    }


    private javax.swing.JPanel createCartItemPanel(final CartItem item) {
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GRAY));
        panel.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 110));
        panel.setOpaque(false);


        javax.swing.JLabel imageLabel = new javax.swing.JLabel();
        if (item.getImage() != null) {
            java.awt.Image scaledImg = ((javax.swing.ImageIcon) item.getImage()).getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
            imageLabel.setIcon(new javax.swing.ImageIcon(scaledImg));
        }
        panel.add(imageLabel, java.awt.BorderLayout.WEST);


        javax.swing.JPanel detailsPanel = new javax.swing.JPanel();
        detailsPanel.setLayout(new javax.swing.BoxLayout(detailsPanel, javax.swing.BoxLayout.Y_AXIS));
        detailsPanel.setOpaque(false);
        detailsPanel.add(new javax.swing.JLabel("Product Name: " + item.getName()));
        detailsPanel.add(new javax.swing.JLabel("Size: " + item.getSize()));
        detailsPanel.add(new javax.swing.JLabel("Price: " + df.format(item.getPrice())));
        panel.add(detailsPanel, java.awt.BorderLayout.CENTER);


        javax.swing.JPanel controlsPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        controlsPanel.setOpaque(false);
        
        javax.swing.JButton minusBtn = new javax.swing.JButton("-");
        javax.swing.JTextField quantityField = new javax.swing.JTextField(String.valueOf(item.getQuantity()), 2);
        quantityField.setEditable(false);
        javax.swing.JButton plusBtn = new javax.swing.JButton("+");
        javax.swing.JButton deleteBtn = new javax.swing.JButton("Delete");
        
        controlsPanel.add(minusBtn);
        controlsPanel.add(quantityField);
        controlsPanel.add(plusBtn);
        controlsPanel.add(deleteBtn);
        panel.add(controlsPanel, java.awt.BorderLayout.EAST);


        deleteBtn.addActionListener(e -> {
            Cart.removeItem(item);
            loadCartItems();
        });
        plusBtn.addActionListener(e -> {
            item.setQuantity(item.getQuantity() + 1);
            loadCartItems();
        });
        minusBtn.addActionListener(e -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                loadCartItems();
            }
        });

        return panel;
    }
    

    private void updateTotals() {
        double subtotal = Cart.calculateSubtotal();
        double discount = 0.0;
        String selectedPromoName = (String) jComboBox1.getSelectedItem();
        String currentUserEmail = Project.Loginnew.loggedInUserEmail;

        if ("10% Off All Jeans (Once per account)".equals(selectedPromoName)) {
            String promoCode = "JEANS_10_PERCENT";
            if (PromotionDataBase.hasUserUsedPromo(currentUserEmail, promoCode)) {
                discount = 0.0; 
                javax.swing.JOptionPane.showMessageDialog(this, "You have used this promotion.");
            } else {
                for (CartItem item : Cart.getItems()) {
                    ProductData product = ProductDataBase.getProductByName(item.getName());
                    if (product != null && "Jean".equalsIgnoreCase(product.getCategory())) {
                        discount += (item.getPrice() * item.getQuantity()) * 0.10;
                    }
                }
            }
        }
        
        else if ("Buy 2 Items, Get 1 Free (Once per account)".equals(selectedPromoName)) {
            String promoCode = "BUY_2_GET_1_FREE";
            if (PromotionDataBase.hasUserUsedPromo(currentUserEmail, promoCode)) {
                discount = 0.0; 
                javax.swing.JOptionPane.showMessageDialog(this, "You have used this promotion.");
            } else {
                java.util.List<CartItem> cartItems = Cart.getItems();
                int totalQuantity = 0;
                for (CartItem item : cartItems) {
                    totalQuantity += item.getQuantity();
                }

                if (totalQuantity >= 2) {
                    CartItem cheapestItem = null;
                    for (CartItem item : cartItems) {
                        if (cheapestItem == null || item.getPrice() < cheapestItem.getPrice()) {
                            cheapestItem = item;
                        }
                    }
                    if (cheapestItem != null) {
                        discount = cheapestItem.getPrice(); 
                    }
                } else {
                    discount = 0.0;
                }
            }
        }


        jLabel4.setText(df.format(subtotal));
        jLabel3.setText("-" + df.format(discount));
        jLabel9.setText(df.format(subtotal - discount));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
