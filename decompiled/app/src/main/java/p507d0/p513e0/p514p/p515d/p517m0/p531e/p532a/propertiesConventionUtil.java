package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p574m.capitalizeDecapitalize;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c0, reason: use source file name */
/* JADX INFO: compiled from: propertiesConventionUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class propertiesConventionUtil {
    /* JADX INFO: renamed from: a */
    public static Name m9449a(Name name, String str, boolean z2, String str2, int i) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!name.isSpecial()) {
            String identifier = name.getIdentifier();
            Intrinsics3.checkNotNullExpressionValue(identifier, "methodName.identifier");
            boolean z3 = false;
            if (StringsJVM.startsWith$default(identifier, str, false, 2, null) && identifier.length() != str.length()) {
                char cCharAt = identifier.charAt(str.length());
                if ('a' <= cCharAt && cCharAt <= 'z') {
                    z3 = true;
                }
                if (!z3) {
                    if (str2 != null) {
                        return Name.identifier(Intrinsics3.stringPlus(str2, Strings4.removePrefix(identifier, str)));
                    }
                    if (!z2) {
                        return name;
                    }
                    String strDecapitalizeSmartForCompiler = capitalizeDecapitalize.decapitalizeSmartForCompiler(Strings4.removePrefix(identifier, str), true);
                    if (Name.isValidIdentifier(strDecapitalizeSmartForCompiler)) {
                        return Name.identifier(strDecapitalizeSmartForCompiler);
                    }
                }
            }
        }
        return null;
    }

    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        JvmAbi jvmAbi = JvmAbi.f23531a;
        return JvmAbi.isGetterName(strAsString) ? Collections2.listOfNotNull(propertyNameByGetMethodName(name)) : JvmAbi.isSetterName(strAsString) ? propertyNamesBySetMethodName(name) : BuiltinSpecialProperties.f23276a.getPropertyNameCandidatesBySpecialGetterName(name);
    }

    public static final Name propertyNameByGetMethodName(Name name) {
        Intrinsics3.checkNotNullParameter(name, "methodName");
        Name nameM9449a = m9449a(name, "get", false, null, 12);
        return nameM9449a == null ? m9449a(name, "is", false, null, 8) : nameM9449a;
    }

    public static final Name propertyNameBySetMethodName(Name name, boolean z2) {
        Intrinsics3.checkNotNullParameter(name, "methodName");
        return m9449a(name, "set", false, z2 ? "is" : null, 4);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name name) {
        Intrinsics3.checkNotNullParameter(name, "methodName");
        return Collections2.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(name, false), propertyNameBySetMethodName(name, true)});
    }
}
