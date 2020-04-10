import java.util.Scanner;
public class CDLL
{
    static Node head;
    static Node tail;
    static Scanner sc = new Scanner(System.in);

    //Creating a circular double linked list
    public void create()
    {
        System.out.println("Enter the number of nodes");
        int n=sc.nextInt();

        Node temp;
        for(int i=0;i<n;i++)
        {
            temp = new Node();
            System.out.println("Enter the value in a node");
            int value= sc.nextInt();
            temp.data=value;

            if(head==null)
            {
                head=tail=temp;
                temp.prev=temp;
                temp.next=temp;
            }
            else
            {
                head.prev=temp;
                temp.prev=tail;
                temp.next=head;
                tail.next=temp;
                tail=temp;
            }
        }

    }

    //Traversal of Circular Double linked list
    public void display()
    {
            System.out.println("Printing values of a list: ");
            Node currentNode = head;
            while (currentNode != null)
            {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
                if (currentNode== head)
                {
                    break;
                }
            }
        }


    //Reverse Traversal of Circular Double linked list
    public void reverseDisplay()
    {
        if(head==null)
        {
            System.out.println("Linked list doesn't exist!");
        }
        else
            {
            System.out.println("Printing values in reverse order: ");
            Node currentNode = tail;
            while (currentNode != null)
            {
                System.out.println(currentNode.data);
                if (currentNode.prev == tail)
                {
                    break;
                }
                currentNode = currentNode.prev;
            }
        }
    }

    //Insertion of a node
    public void insertNode()
    {

        Node temp = new Node();
        System.out.println("\n1.Insert at the start. \n2.Insert at the specific position. \n3.Insert at the end");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter the value in a node");
                int value1 = sc.nextInt();
                temp.data = value1;
                if(head==null)
                {
                    head=tail=temp;
                    head.prev=temp;
                    tail.next=head;
                }
                else
                {
                    head.prev=temp;
                    temp.next=head;
                    temp.prev=tail;
                    head=temp;
                    tail.next=head;
                }
                break;

            case 2:
                System.out.println("Enter the value in a node");
                int value2= sc.nextInt();
                temp.data = value2;
                System.out.println("Enter the position where you want to create a node");
                int position = sc.nextInt();
                if(head==null && position==1)
                {
                    head=tail=temp;
                    head.prev=temp;
                    tail.next=head;

                }
                else if(head!=null && position==1)
                {
                    head.prev=temp;
                    temp.next=head;
                    temp.prev=tail;
                    head=temp;
                    tail.next=head;

                }
                else
                {
                    Node currentNode=head;
                    int counter=1;
                    while(currentNode!=null)
                    {
                        if(counter==position-1)
                        {
                            break;
                        }
                        currentNode=currentNode.next;
                        counter++;
                        if(currentNode==head)
                        {
                            break;
                        }
                    }
                    if(currentNode==tail)
                    {
                        tail.next=temp;
                        temp.prev=tail;
                        temp.next=head;
                        tail=temp;
                        head.prev=tail;

                    }
                    else if(currentNode!=head || (currentNode==head && position==2))
                    {
                        temp.next=currentNode.next;
                        temp.prev=currentNode;
                        currentNode.next.prev=temp;
                        currentNode.next=temp;
                    }
                    else
                    {
                        System.out.println("Invalid Position");
                    }

                }
                break;

            case 3 :
                System.out.println("Enter the value in a node");
                int value3= sc.nextInt();
                temp.data = value3;
                if(head==null)
                {
                    head = tail = temp;
                    head.prev = temp;
                    tail.next = head;
                }
                else
                {
                    tail.next=temp;
                    temp.prev=tail;
                    temp.next=head;
                    tail=temp;
                    head.prev=tail;
                }
                break;

            default:
                System.out.println("Invalid choice!!  \n\n Please select a suitable choice ");
                insertNode();

        }
    }

    //Search a value in Circular Double Linked list
    public void search()
    {
        System.out.println("Enter the value to search: ");
        int value=sc.nextInt();
        Node currentNode = head;
        while(currentNode!=null)
        {
            if(currentNode.data==value)
            {
                break;
            }
            currentNode=currentNode.next;
            if(currentNode==head)
            {
                break;
            }
        }
        if(currentNode!=head)
        {
            System.out.println("Value found");
        }
        else
        {
            System.out.println("Value doesn't found!");
        }

    }

    //Deletion of a node
    public void delete()
    {
        System.out.println("\n1.Delete the first node. \n2.Delete the specific node. \n3.Delete the last node.");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
                if(head==null)
                {
                    System.out.println("There is no linked list!");
                }
                else if(head==tail)
                {
                    head.prev=null;
                    head.next=null;
                    head=null;
                    tail=null;
                }
                else
                {
                    head=head.next;
                    head.prev=tail;
                    tail.next=head;

                }
                break;

            case 2:
                System.out.println("Enter the position where you want to delete");
                int position=sc.nextInt();
                if(head==null)
                {
                    System.out.println("Linked list doesn't exist");
                }
                else if(head==tail && position==1)
                {
                    head.prev=null;
                    head.next=null;
                    head=null;
                    tail=null;

                }
                else if(head!=tail && position==1)
                {
                    head=head.next;
                    head.prev=tail;
                    tail.next=head;
                }
                else
                {
                    Node currentNode=head;
                    int counter=1;
                    while(currentNode!=tail)
                    {
                        if(counter==position-1)
                        {
                            break;
                        }
                        currentNode=currentNode.next;
                        counter++;
                    }
                    if(currentNode.next==tail)
                    {
                        tail.prev.next=head;
                        tail=tail.prev;

                    }
                    else if(currentNode!=tail)
                    {
                        currentNode.next=currentNode.next.next;
                        currentNode.next.prev=currentNode;


                    }
                    else
                    {
                        System.out.println("Invalid Position!!");
                    }

                }
                break;

            case 3:
                if(head==null)
                {
                    System.out.println("There is no linked list.");

                }
                else if(head==tail)
                {
                    head.prev=null;
                    head.next=null;
                    head=null;
                    tail=null;


                }
                else
                {
                    tail.prev.next=head;
                    tail=tail.prev;

                }
                break;

            default:
                System.out.println("Invalid choice!!Please select again");
                delete();
        }


    }

    //Deleting the entire Circular double linked list
    public void deleteCDLL()
    {
        Node currentNode = tail;
        while(currentNode!=null)
        {
            currentNode=currentNode.prev;
            tail.prev=null;
        }
        tail.next=null;
        head=null;
        tail=null;

    }


    }








