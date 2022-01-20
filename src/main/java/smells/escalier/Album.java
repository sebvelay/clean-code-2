package smells.escalier;

import java.util.Set;

public class Album {
    private final String title;
    private final Set<Track> tracks;

    private Album(String title, Set<Track> tracks) {
        this.title = title;
        this.tracks = tracks;
    }

    public Set<Track> tracks() {
        return this.tracks;
    }

    public static Builder titled(String title) {
        return new Builder(title);
    }

    public static class Builder {
        private final String title;
        private Set<Track> tracks;

        public Builder(String title) {
            this.title = title;
        }

        public Album containingTracks(Track... tracks) {
            this.tracks = Set.of(tracks);
            return new Album(this.title, this.tracks);
        }

    }
}