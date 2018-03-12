package com.company;

import java.util.*;

public class emailReferenceSort {
    class Email {
        int id;
        int[] references;
    }
    public List<Email> solve(List<Email> emails) {
        Map<Integer, Email> map = new HashMap<>();
        for (Email email : emails) {
            map.put(email.id, email);
        }
        Set<Integer> visited = new HashSet<>();
        List<Email> res = new ArrayList<>();
        for (int i = 0; i < emails.size(); ++i) {
            if (!visited.contains(emails.get(i).id)) {
                visited.add(emails.get(i).id);
                dfs(visited, emails.get(i), map, res);
            }
        }
        return res;
    }
    public void dfs(Set<Integer> visited, Email cur, Map<Integer, Email> map, List<Email> res) {
        for (Integer nei : cur.references) {
            Email neiEmail = map.get(nei);
            if (!visited.contains(neiEmail.id)) {
                visited.add(neiEmail.id);
                dfs(visited, neiEmail, map, res);
            }
        }
        res.add(cur);
    }
}
