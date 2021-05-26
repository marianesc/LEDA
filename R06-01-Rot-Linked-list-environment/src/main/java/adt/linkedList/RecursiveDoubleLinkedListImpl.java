package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				this.getNext().insert(element);
			} else {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {

			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				setPrevious(new RecursiveDoubleLinkedListImpl<>());
			} else {
				RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<>();

				auxNode.setData(this.getData());
				auxNode.setNext(this.getNext());
				this.setData(element);
				this.setNext(auxNode);
				auxNode.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) auxNode.getNext()).setPrevious(auxNode);
			}

		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.getPrevious() == null && this.getNext().isEmpty()) {
				this.setData(null);
				this.setPrevious(null);
				this.setNext(null);
			} else {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(null);
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
