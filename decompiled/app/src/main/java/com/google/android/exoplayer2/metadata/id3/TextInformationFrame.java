package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* loaded from: classes3.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new C10735a();

    /* renamed from: k */
    @Nullable
    public final String f20000k;

    /* renamed from: l */
    public final String f20001l;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.TextInformationFrame$a */
    public class C10735a implements Parcelable.Creator<TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }
    }

    public TextInformationFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.f20000k = str2;
        this.f20001l = str3;
    }

    /* renamed from: a */
    public static List<Integer> m8882a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return Util2.m2993a(this.f19989j, textInformationFrame.f19989j) && Util2.m2993a(this.f20000k, textInformationFrame.f20000k) && Util2.m2993a(this.f20001l, textInformationFrame.f20001l);
    }

    public int hashCode() {
        int iM863m = outline.m863m(this.f19989j, 527, 31);
        String str = this.f20000k;
        int iHashCode = (iM863m + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20001l;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: n */
    public void mo8878n(MediaMetadata.b bVar) {
        String str = this.f19989j;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c = '\b';
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = '\t';
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = '\n';
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c = 11;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c = '\f';
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c = '\r';
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c = 14;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c = 15;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 16;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = 17;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = 18;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c = 19;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = 20;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 21;
                }
                break;
        }
        try {
            switch (c) {
                case 0:
                case '\n':
                    bVar.f7409c = this.f20001l;
                    break;
                case 1:
                case 11:
                    bVar.f7431y = this.f20001l;
                    break;
                case 2:
                case '\f':
                    int i = Integer.parseInt(this.f20001l.substring(2, 4));
                    int i2 = Integer.parseInt(this.f20001l.substring(0, 2));
                    bVar.f7425s = Integer.valueOf(i);
                    bVar.f7426t = Integer.valueOf(i2);
                    break;
                case 3:
                case 17:
                    bVar.f7408b = this.f20001l;
                    break;
                case 4:
                case 18:
                    bVar.f7410d = this.f20001l;
                    break;
                case 5:
                case 19:
                    bVar.f7432z = this.f20001l;
                    break;
                case 6:
                case 20:
                    String[] strArrM2987H = Util2.m2987H(this.f20001l, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                    int i3 = Integer.parseInt(strArrM2987H[0]);
                    Integer numValueOf = strArrM2987H.length > 1 ? Integer.valueOf(Integer.parseInt(strArrM2987H[1])) : null;
                    bVar.f7420n = Integer.valueOf(i3);
                    bVar.f7421o = numValueOf;
                    break;
                case 7:
                case 16:
                    bVar.f7407a = this.f20001l;
                    break;
                case '\b':
                case 15:
                    bVar.f7430x = this.f20001l;
                    break;
                case '\t':
                case 21:
                    bVar.f7424r = Integer.valueOf(Integer.parseInt(this.f20001l));
                    break;
                case '\r':
                    ArrayList arrayList = (ArrayList) m8882a(this.f20001l);
                    int size = arrayList.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.f7426t = (Integer) arrayList.get(2);
                            }
                        }
                        bVar.f7425s = (Integer) arrayList.get(1);
                    }
                    bVar.f7424r = (Integer) arrayList.get(0);
                    break;
                case 14:
                    ArrayList arrayList2 = (ArrayList) m8882a(this.f20001l);
                    int size2 = arrayList2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.f7429w = (Integer) arrayList2.get(2);
                            }
                        }
                        bVar.f7428v = (Integer) arrayList2.get(1);
                    }
                    bVar.f7427u = (Integer) arrayList2.get(0);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f19989j;
        String str2 = this.f20000k;
        String str3 = this.f20001l;
        StringBuilder sbM831S = outline.m831S(outline.m841b(str3, outline.m841b(str2, outline.m841b(str, 22))), str, ": description=", str2, ": value=");
        sbM831S.append(str3);
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19989j);
        parcel.writeString(this.f20000k);
        parcel.writeString(this.f20001l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInformationFrame(Parcel parcel) {
        String string = parcel.readString();
        int i = Util2.f6708a;
        super(string);
        this.f20000k = parcel.readString();
        this.f20001l = parcel.readString();
    }
}
