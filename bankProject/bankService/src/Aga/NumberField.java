package Aga;

import java.awt.event.*;

import javax.swing.*;

public class NumberField extends JTextField implements KeyListener {
 private static final long serialVersionUID = 1;
 
 public NumberField() {
  addKeyListener(this);
 }

 public NumberField(int size) {
	  addKeyListener(this);
	  this.setColumns(size);
	  
	 }
 public void keyPressed(KeyEvent e) {
 }

 public void keyReleased(KeyEvent e) {
 }

 public void keyTyped(KeyEvent e) {
  // Get the current character you typed...
  char c = e.getKeyChar();
  
  if (!Character.isDigit(c)) {
   e.consume();
   return;
  }
 }
}