/** Represents a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        if (size == maxSize) return false;
        this.tracks[size] = track;
        size++;
        return true;
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.tracks[i].toString()).append("\n");
        }
        return sb.toString();
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
    public void removeLast() {
        if (this.size == 0) return;
        tracks[this.size - 1] = null;
        this.size--;
    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        int totalDuration = 0;
        for (int i = 0; i < this.size; i++) {
            totalDuration += this.tracks[i].getDuration();
        }
        return totalDuration;
    }

    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        for (int i = 0; i < this.size; i++) {
            if (title.equals(this.tracks[i].getTitle())) return i;
        }
        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) {
        if (i < 0 || i > this.size || this.size == this.maxSize) return false;
        if (this.size == 0 || i == this.size) {
            this.add(track); 
            return true;
        }
        for (int j = this.size - 1; j >= i; j--) {
            this.tracks[j+1] = this.tracks[j];
        }
        this.tracks[i] = track;
        size++;
        return true;
    }

    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) {
        if (this.size == 0 || i < 0 || i >= this.size) return;
        for (int j = i; j < this.size - 1; j++) {
            this.tracks[j] = this.tracks[j+1];
        }
        tracks[this.size-1] = null;
        size--;
    }

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, does nothing. */
    public void remove(String title) {
        for (int i = 0; i < this.size; i++) {
            if (title.equals(this.tracks[i].getTitle())) {
                remove(i);
                return;
            }
        }
    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() {
        if (this.size == 0) return;
        remove(0);
    }
}