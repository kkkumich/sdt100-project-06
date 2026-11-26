package part3_contacts;

import common.Input;
import java.util.Arrays;
public class Main {
    // Optional task: fixed capacity plus an independent count, not an ArrayList.
    private final String[] contacts=new String[100];
    private int count=0;
    public int size() { return count; }
    public String get(int index) { check(index); return contacts[index]; }
    private void check(int index) { if(index<0 || index>=count) throw new IllegalArgumentException("No such contact"); }
    public void add(String value) {
        if(count==contacts.length) throw new IllegalArgumentException("Contact storage is full");
        if(value.trim().isEmpty() || value.equals("DELETED")) throw new IllegalArgumentException("Contact cannot be blank or DELETED");
        contacts[count++]=value.trim();
    }
    public void edit(int index,String value) {
        check(index); if(value.trim().isEmpty() || value.equals("DELETED")) throw new IllegalArgumentException("Invalid contact");
        contacts[index]=value.trim();
    }
    public void delete(int index) { check(index); contacts[index]="DELETED"; }
    public void clear() { Arrays.fill(contacts,""); count=0; }
    public void show(String phrase) {
        boolean found=false;
        for(int i=0;i<count;i++) if(!contacts[i].equals("DELETED") && contacts[i].contains(phrase)) {
            System.out.println((i+1)+". "+contacts[i]); found=true;
        }
        if(!found) System.out.println("No matching contacts.");
    }
    public static void main(String[] args) {
        Main book=new Main();
        while(true) {
            System.out.println("1 Add | 2 Show | 3 Search | 4 Edit | 5 Delete | 6 Delete all | 7 Samples | 0 Exit");
            int choice=Input.integer("Choose: ",0,7);
            try {
                switch(choice) {
                    case 0: return;
                    case 1:
                        while(true) { String s=Input.text("Contact (empty line finishes): "); if(s.isEmpty()) break; book.add(s); } break;
                    case 2: book.show(""); break;
                    case 3: book.show(Input.text("Search phrase (case-sensitive): ")); break;
                    case 4:
                        if(book.size()==0) { System.out.println("No contacts."); break; }
                        int index=Input.integer("Contact number: ",1,book.size())-1;
                        System.out.println("Current: "+book.get(index)); book.edit(index,Input.text("New value: ")); break;
                    case 5:
                        if(book.size()==0) { System.out.println("No contacts."); break; }
                        book.delete(Input.integer("Contact number: ",1,book.size())-1); break;
                    case 6: book.clear(); break;
                    case 7: book.add("Demo Ada, ada@example.test"); book.add("Demo Linus, linus@example.test"); break;
                    default: throw new IllegalStateException("Unexpected choice");
                }
            } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); }
        }
    }
}
