package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import p507d0.p580t._Arrays;

/* compiled from: FqNameUnsafe.java */
/* renamed from: d0.e0.p.d.m0.g.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class FqNameUnsafe {

    /* renamed from: a */
    public static final Name f24082a = Name.special("<root>");

    /* renamed from: b */
    public static final Pattern f24083b = Pattern.compile("\\.");

    /* renamed from: c */
    public static final Function1<String, Name> f24084c = new a();

    /* renamed from: d */
    public final String f24085d;

    /* renamed from: e */
    public transient FqName f24086e;

    /* renamed from: f */
    public transient FqNameUnsafe f24087f;

    /* renamed from: g */
    public transient Name f24088g;

    /* compiled from: FqNameUnsafe.java */
    /* renamed from: d0.e0.p.d.m0.g.c$a */
    public static class a implements Function1<String, Name> {
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Name invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public Name invoke2(String str) {
            return Name.guessByFirstCharacter(str);
        }
    }

    public FqNameUnsafe(String str, FqName fqName) {
        if (str == null) {
            m9818a(0);
            throw null;
        }
        this.f24085d = str;
        this.f24086e = fqName;
    }

    /* renamed from: a */
    public static /* synthetic */ void m9818a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static FqNameUnsafe topLevel(Name name) {
        if (name != null) {
            return new FqNameUnsafe(name.asString(), FqName.f24079a.toUnsafe(), name);
        }
        m9818a(16);
        throw null;
    }

    public String asString() {
        String str = this.f24085d;
        if (str != null) {
            return str;
        }
        m9818a(4);
        throw null;
    }

    /* renamed from: b */
    public final void m9819b() {
        int iLastIndexOf = this.f24085d.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.f24088g = Name.guessByFirstCharacter(this.f24085d.substring(iLastIndexOf + 1));
            this.f24087f = new FqNameUnsafe(this.f24085d.substring(0, iLastIndexOf));
        } else {
            this.f24088g = Name.guessByFirstCharacter(this.f24085d);
            this.f24087f = FqName.f24079a.toUnsafe();
        }
    }

    public FqNameUnsafe child(Name name) {
        String strAsString;
        if (name == null) {
            m9818a(9);
            throw null;
        }
        if (isRoot()) {
            strAsString = name.asString();
        } else {
            strAsString = this.f24085d + "." + name.asString();
        }
        return new FqNameUnsafe(strAsString, this, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqNameUnsafe) && this.f24085d.equals(((FqNameUnsafe) obj).f24085d);
    }

    public int hashCode() {
        return this.f24085d.hashCode();
    }

    public boolean isRoot() {
        return this.f24085d.isEmpty();
    }

    public boolean isSafe() {
        return this.f24086e != null || asString().indexOf(60) < 0;
    }

    public FqNameUnsafe parent() {
        FqNameUnsafe fqNameUnsafe = this.f24087f;
        if (fqNameUnsafe != null) {
            if (fqNameUnsafe != null) {
                return fqNameUnsafe;
            }
            m9818a(7);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        m9819b();
        FqNameUnsafe fqNameUnsafe2 = this.f24087f;
        if (fqNameUnsafe2 != null) {
            return fqNameUnsafe2;
        }
        m9818a(8);
        throw null;
    }

    public List<Name> pathSegments() {
        List<Name> listEmptyList = isRoot() ? Collections.emptyList() : _Arrays.map(f24083b.split(this.f24085d), f24084c);
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9818a(14);
        throw null;
    }

    public Name shortName() {
        Name name = this.f24088g;
        if (name != null) {
            if (name != null) {
                return name;
            }
            m9818a(10);
            throw null;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        m9819b();
        Name name2 = this.f24088g;
        if (name2 != null) {
            return name2;
        }
        m9818a(11);
        throw null;
    }

    public Name shortNameOrSpecial() {
        if (isRoot()) {
            Name name = f24082a;
            if (name != null) {
                return name;
            }
            m9818a(12);
            throw null;
        }
        Name nameShortName = shortName();
        if (nameShortName != null) {
            return nameShortName;
        }
        m9818a(13);
        throw null;
    }

    public boolean startsWith(Name name) {
        if (name == null) {
            m9818a(15);
            throw null;
        }
        if (isRoot()) {
            return false;
        }
        int iIndexOf = this.f24085d.indexOf(46);
        String str = this.f24085d;
        String strAsString = name.asString();
        if (iIndexOf == -1) {
            iIndexOf = this.f24085d.length();
        }
        return str.regionMatches(0, strAsString, 0, iIndexOf);
    }

    public FqName toSafe() {
        FqName fqName = this.f24086e;
        if (fqName != null) {
            if (fqName != null) {
                return fqName;
            }
            m9818a(5);
            throw null;
        }
        FqName fqName2 = new FqName(this);
        this.f24086e = fqName2;
        if (fqName2 != null) {
            return fqName2;
        }
        m9818a(6);
        throw null;
    }

    public String toString() {
        String strAsString = isRoot() ? f24082a.asString() : this.f24085d;
        if (strAsString != null) {
            return strAsString;
        }
        m9818a(17);
        throw null;
    }

    public FqNameUnsafe(String str) {
        if (str != null) {
            this.f24085d = str;
        } else {
            m9818a(2);
            throw null;
        }
    }

    public FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name) {
        if (str != null) {
            this.f24085d = str;
            this.f24087f = fqNameUnsafe;
            this.f24088g = name;
            return;
        }
        m9818a(3);
        throw null;
    }
}
