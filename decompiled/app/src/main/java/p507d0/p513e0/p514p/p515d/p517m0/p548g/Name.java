package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: Name.java */
/* renamed from: d0.e0.p.d.m0.g.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Name implements Comparable<Name> {

    /* renamed from: j */
    public final String f24089j;

    /* renamed from: k */
    public final boolean f24090k;

    public Name(String str, boolean z2) {
        if (str == null) {
            m9820f(0);
            throw null;
        }
        this.f24089j = str;
        this.f24090k = z2;
    }

    /* renamed from: f */
    public static /* synthetic */ void m9820f(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static Name guessByFirstCharacter(String str) {
        if (str != null) {
            return str.startsWith("<") ? special(str) : identifier(str);
        }
        m9820f(6);
        throw null;
    }

    public static Name identifier(String str) {
        if (str != null) {
            return new Name(str, false);
        }
        m9820f(3);
        throw null;
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            m9820f(4);
            throw null;
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name special(String str) {
        if (str == null) {
            m9820f(5);
            throw null;
        }
        if (str.startsWith("<")) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException(outline.m883w("special name must start with '<': ", str));
    }

    public String asString() {
        String str = this.f24089j;
        if (str != null) {
            return str;
        }
        m9820f(1);
        throw null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Name name) {
        return compareTo2(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.f24090k == name.f24090k && this.f24089j.equals(name.f24089j);
    }

    public String getIdentifier() {
        if (this.f24090k) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strAsString = asString();
        if (strAsString != null) {
            return strAsString;
        }
        m9820f(2);
        throw null;
    }

    public int hashCode() {
        return (this.f24089j.hashCode() * 31) + (this.f24090k ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.f24090k;
    }

    public String toString() {
        return this.f24089j;
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Name name) {
        return this.f24089j.compareTo(name.f24089j);
    }
}
