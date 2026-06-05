class Solution {
    class Word{
        String word;
        int idx;
        Word(String word, int idx){
            this.word = word;
            this.idx = idx;
        }
    }
    Node root;
    class Node{
        Set<Character> seen;
        int idx = -1;
        boolean end = false;
        List<Node> childs; // in the required order
        char ch;
        Node(char ch){
            this.childs = new ArrayList<>();
            seen = new HashSet<>();
            this.ch = ch;
        }
    }
    void add(StringBuilder sb, int idx){
        Node cur = this.root;
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            int cidx = -1;
            if(cur.seen.contains(ch)){
                // iterate and find
                for(int j=0;j<cur.childs.size();j++){
                    if(cur.childs.get(j).ch==ch){
                        cidx = j;
                        break;
                    }
                }
            }else{
                cur.seen.add(ch);
                cur.childs.add(new Node(ch));
                cidx = cur.childs.size()-1;
            }
            cur = cur.childs.get(cidx);
        }
        if(cur.end) return; // prevents overriding by same words
        cur.end = true;
        cur.idx = idx;
    }
    int search(StringBuilder sb){ // search as much as sb prefix as possible
        Node cur = this.root;
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            if(!cur.seen.contains(ch)){
                break; // new character sequence found no further characters can be matched just break out and start moving to the first childs.
            }else{
                for(Node c: cur.childs){
                    if(c.ch==ch){
                        cur = c;
                        break;
                    }
                }
            }
        }
        while(!cur.end){
            cur = cur.childs.get(0); // default moving.
        }
        return cur.idx;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int qn = wordsQuery.length, wn = wordsContainer.length;
        Word[] words = new Word[wn];
        for(int i=0;i<wn;i++){
            words[i] = new Word(wordsContainer[i],i);
        }
        Arrays.sort(words,(a,b)->{
            // int cmp = Integer.compare(a.word.length(), b.word.length());
            // if(cmp==0) return Integer.compare(a.idx,b.idx);
            // return cmp;
            return Integer.compare(a.word.length(), b.word.length());
        }); //Java's object-array sort is stable. if length same then og relative order is preserved.
        this.root = new Node('^');
        for(Word w: words){
            add(new StringBuilder(w.word).reverse(), w.idx);
        } 
        int[] ans = new int[qn];
        for(int i=0;i<qn;i++){
            ans[i] = search(new StringBuilder(wordsQuery[i]).reverse());
        }
        return ans;
    }
}