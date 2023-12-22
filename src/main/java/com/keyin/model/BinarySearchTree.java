package com.keyin.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    private TreeNode insertRecursively(TreeNode currentNode, int value) {
        if (currentNode == null) {
            return new TreeNode(value);
        }

        if (value < currentNode.getValue()) {
            currentNode.setLeft(insertRecursively(currentNode.getLeft(), value));
        }
        else {
            currentNode.setRight(insertRecursively(currentNode.getRight(), value));
        }

        return currentNode;
    }



    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            return objectMapper.writeValueAsString(root);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
