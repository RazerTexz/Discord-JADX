package p007b.p225i.p226a.p242c.p267x2.p274i0;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.h, reason: use source file name */
/* JADX INFO: compiled from: MetadataUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataUtil {

    /* JADX INFO: renamed from: a */
    @VisibleForTesting
    public static final String[] f8418a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    /* JADX INFO: renamed from: a */
    public static CommentFrame m3721a(int i, ParsableByteArray parsableByteArray) {
        int iM3086f = parsableByteArray.m3086f();
        if (parsableByteArray.m3086f() == 1684108385) {
            parsableByteArray.m3080F(8);
            String strM3095o = parsableByteArray.m3095o(iM3086f - 16);
            return new CommentFrame("und", strM3095o, strM3095o);
        }
        String strValueOf = String.valueOf(Atom.m3699a(i));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(strValueOf) : new String("Failed to parse comment attribute: "));
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static ApicFrame m3722b(ParsableByteArray parsableByteArray) {
        int iM3086f = parsableByteArray.m3086f();
        if (parsableByteArray.m3086f() != 1684108385) {
            Log.w("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iM3086f2 = parsableByteArray.m3086f() & ViewCompat.MEASURED_SIZE_MASK;
        String str = iM3086f2 == 13 ? "image/jpeg" : iM3086f2 == 14 ? "image/png" : null;
        if (str == null) {
            outline.m852g0(41, "Unrecognized cover art flags: ", iM3086f2, "MetadataUtil");
            return null;
        }
        parsableByteArray.m3080F(4);
        int i = iM3086f - 16;
        byte[] bArr = new byte[i];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i);
        parsableByteArray.f6794b += i;
        return new ApicFrame(str, null, 3, bArr);
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public static TextInformationFrame m3723c(int i, String str, ParsableByteArray parsableByteArray) {
        int iM3086f = parsableByteArray.m3086f();
        if (parsableByteArray.m3086f() == 1684108385 && iM3086f >= 22) {
            parsableByteArray.m3080F(10);
            int iM3105y = parsableByteArray.m3105y();
            if (iM3105y > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(iM3105y);
                String string = sb.toString();
                int iM3105y2 = parsableByteArray.m3105y();
                if (iM3105y2 > 0) {
                    String strValueOf = String.valueOf(string);
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 12);
                    sb2.append(strValueOf);
                    sb2.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                    sb2.append(iM3105y2);
                    string = sb2.toString();
                }
                return new TextInformationFrame(str, null, string);
            }
        }
        String strValueOf2 = String.valueOf(Atom.m3699a(i));
        Log.w("MetadataUtil", strValueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(strValueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public static TextInformationFrame m3724d(int i, String str, ParsableByteArray parsableByteArray) {
        int iM3086f = parsableByteArray.m3086f();
        if (parsableByteArray.m3086f() == 1684108385) {
            parsableByteArray.m3080F(8);
            return new TextInformationFrame(str, null, parsableByteArray.m3095o(iM3086f - 16));
        }
        String strValueOf = String.valueOf(Atom.m3699a(i));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse text attribute: ".concat(strValueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public static Id3Frame m3725e(int i, String str, ParsableByteArray parsableByteArray, boolean z2, boolean z3) {
        int iM3726f = m3726f(parsableByteArray);
        if (z3) {
            iM3726f = Math.min(1, iM3726f);
        }
        if (iM3726f >= 0) {
            return z2 ? new TextInformationFrame(str, null, Integer.toString(iM3726f)) : new CommentFrame("und", str, Integer.toString(iM3726f));
        }
        String strValueOf = String.valueOf(Atom.m3699a(i));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(strValueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    /* JADX INFO: renamed from: f */
    public static int m3726f(ParsableByteArray parsableByteArray) {
        parsableByteArray.m3080F(4);
        if (parsableByteArray.m3086f() == 1684108385) {
            parsableByteArray.m3080F(8);
            return parsableByteArray.m3100t();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
