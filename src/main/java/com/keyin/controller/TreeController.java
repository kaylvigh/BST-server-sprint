package com.keyin.controller;

import com.keyin.model.BinarySearchTree;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tree")
@CrossOrigin(origins = "http://localhost:3000")
public class TreeController {

    private final List<BinarySearchTree> treeArchive = new ArrayList<>();

    @PostMapping("/create")
    public String createTree(@RequestParam("numbers") String numbers) {
        BinarySearchTree tree = new BinarySearchTree();
        for (String number : numbers.split("\\s+")) {
            tree.insert(Integer.parseInt(number.trim()));
        }

        treeArchive.add(tree);
        return tree.toJson();
    }

    @GetMapping("/archive")
    public List<String> getArchivedTrees() {
        List<String> jsonTrees = new ArrayList<>();
        for (BinarySearchTree tree : treeArchive) {
            jsonTrees.add(tree.toJson());
        }
        return jsonTrees;
    }
}
