package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;

/* compiled from: SpecialNames.java */
/* renamed from: d0.e0.p.d.m0.g.g, reason: use source file name */
/* loaded from: classes3.dex */
public class SpecialNames {

    /* renamed from: a */
    public static final Name f24092a = Name.special("<no name provided>");

    /* renamed from: b */
    public static final Name f24093b;

    /* renamed from: c */
    public static final Name f24094c;

    static {
        Name.special("<root package>");
        f24093b = Name.identifier("Companion");
        f24094c = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Name.special("<anonymous>");
    }

    /* renamed from: a */
    public static /* synthetic */ void m9821a(int i) {
        String str = i != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 1 ? 2 : 3];
        if (i != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        }
        if (i != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static boolean isSafeIdentifier(Name name) {
        if (name != null) {
            return (name.asString().isEmpty() || name.isSpecial()) ? false : true;
        }
        m9821a(1);
        throw null;
    }

    public static Name safeIdentifier(Name name) {
        if (name == null || name.isSpecial()) {
            name = f24094c;
        }
        if (name != null) {
            return name;
        }
        m9821a(0);
        throw null;
    }
}
