package smells.escalier;


import java.util.Set;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static smells.escalier.MusicLibrary.albums;
import static smells.escalier.MusicLibrary.guitar;
import static smells.escalier.MusicLibrary.violin;

public class MusicSearchServiceTest {

    private final MusicSearchService musicSearchService = new MusicSearchService();

    @Test
    public void should_count_total_running_time() {
        int totalRunningTime = musicSearchService.totalRunningTime(albums);
        assertThat(totalRunningTime).isEqualTo(119);
    }

    @Test public void should_find_cord_instruments_used_in_long_tracks() {
        Set<Instrument> instrumentsUsedInLongTracks = musicSearchService.cordInstrumentsUsedInLongTracks(albums);
        assertThat(instrumentsUsedInLongTracks).hasSize(2).contains(guitar, violin);
    }

}
