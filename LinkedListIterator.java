public class LinkedListIterator  implements Iterator<E>
   {
      private Node<E> next;

      public LinkedListIterator()
      {
         next = head;
      }

      public boolean hasNext()
      {
         return next != null;
      }

      public E next()
      {
         if (!hasNext()) throw new NoSuchElementException();
         E res = next.data;
         next = next.next;
         return res;
      }

      public void remove() { throw new UnsupportedOperationException(); }
   }