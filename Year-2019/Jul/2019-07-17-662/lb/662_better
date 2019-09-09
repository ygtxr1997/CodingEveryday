public int widthOfBinaryTree_Better(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int maxSpan = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
//            int left = Integer.MAX_VALUE;
            int right = 0;
            int diff = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    //以左边的第一个节点为作为基础，之后每一个值都会减去这个值
                    diff = node.val;
                }

                //每个节点的值更新为在每层的位置
                node.val = node.val - diff;
                //left恒定为0
//                left = Math.min(left, node.val);
                right = Math.max(right, node.val);

                if (node.left != null) {
                    //当前节点的左节点的位置为翻倍
                    node.left.val = node.val * 2;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    //右节点则则加1
                    node.right.val = node.val * 2 + 1;
                    queue.offer(node.right);
                }
            }
//            maxSpan = Math.max(maxSpan, right - left + 1);
            maxSpan = Math.max(maxSpan,right + 1);
        }
        return maxSpan;
    }
