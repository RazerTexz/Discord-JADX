package b.a.y.o0;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SpeakersItem.kt */
/* loaded from: classes2.dex */
public abstract class d implements MGRecyclerDataPayload {
    public final String j;
    public final int k;

    /* compiled from: SpeakersItem.kt */
    public static final class a extends d {
        public final User l;
        public final GuildMember m;
        public final String n;
        public final String o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(User user, GuildMember guildMember, String str, String str2) {
            super(String.valueOf(user.getId()), 0, null);
            m.checkNotNullParameter(user, "user");
            m.checkNotNullParameter(str, "displayName");
            m.checkNotNullParameter(str2, "positionKey");
            this.l = user;
            this.m = guildMember;
            this.n = str;
            this.o = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.areEqual(this.l, aVar.l) && m.areEqual(this.m, aVar.m) && m.areEqual(this.n, aVar.n) && m.areEqual(this.o, aVar.o);
        }

        public int hashCode() {
            User user = this.l;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            GuildMember guildMember = this.m;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            String str = this.n;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.o;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("IndividualSpeakerItem(user=");
            sbU.append(this.l);
            sbU.append(", guildMember=");
            sbU.append(this.m);
            sbU.append(", displayName=");
            sbU.append(this.n);
            sbU.append(", positionKey=");
            return b.d.b.a.a.J(sbU, this.o, ")");
        }
    }

    /* compiled from: SpeakersItem.kt */
    public static final class b extends d {
        public final int l;
        public final String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, String str) {
            super("other-speakers-count", 1, null);
            m.checkNotNullParameter(str, "positionKey");
            this.l = i;
            this.m = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.l == bVar.l && m.areEqual(this.m, bVar.m);
        }

        public int hashCode() {
            int i = this.l * 31;
            String str = this.m;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("OtherSpeakersCountItem(otherSpeakersCount=");
            sbU.append(this.l);
            sbU.append(", positionKey=");
            return b.d.b.a.a.J(sbU, this.m, ")");
        }
    }

    public d(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.j = str;
        this.k = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.j;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.k;
    }
}
