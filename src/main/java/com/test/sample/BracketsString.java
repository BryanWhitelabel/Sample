/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author litem
 */
public class BracketsString {

    public static void main(String[] args) {
        String text = "{}{[]}";
        System.out.println("Is brackets string valid? " + isBracketStringValid(text));
    }

    public static boolean isBracketStringValid(String text) {
        boolean res = false;

        if (text != null && !text.trim().isEmpty() && (text.length() % 2) == 0) {
            HashMap open_closing_hm = new HashMap();
            open_closing_hm.put("(", ")");
            open_closing_hm.put("{", "}");
            open_closing_hm.put("[", "]");

            List<String> list = new ArrayList();

            res = true;
            for (int i = 0; i < text.length(); i++) {
                String current_char = String.valueOf(text.charAt(i));
                String expected_partner_char = (String) open_closing_hm.get(current_char);

                if (expected_partner_char != null) {
                    list.add(0, expected_partner_char);
                } else {
                    if (!list.isEmpty() && list.get(0).equals(current_char)) {
                        list.remove(0);
                    } else {
                        res = false;
                        break;
                    }
                }
            }

            if (!list.isEmpty()) {
                res = false;
            }
        }

        return res;
    }
}
