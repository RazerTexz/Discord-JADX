package p507d0.p513e0.p514p.p515d.p517m0.p529d;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation4;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.a, reason: use source file name */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class utils {
    public static final void record(LookupTracker lookupTracker, LookupLocation2 lookupLocation2, ClassDescriptor classDescriptor, Name name) {
        LookupLocation location;
        Intrinsics3.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics3.checkNotNullParameter(lookupLocation2, "from");
        Intrinsics3.checkNotNullParameter(classDescriptor, "scopeOwner");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (lookupTracker == LookupTracker.a.f23110a || (location = lookupLocation2.getLocation()) == null) {
            return;
        }
        LookupLocation4 position = lookupTracker.getRequiresPosition() ? location.getPosition() : LookupLocation4.f23135j.getNO_POSITION();
        String filePath = location.getFilePath();
        String strAsString = DescriptorUtils.getFqName(classDescriptor).asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "getFqName(scopeOwner).asString()");
        LookupTracker2 lookupTracker2 = LookupTracker2.CLASSIFIER;
        String strAsString2 = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString2, "name.asString()");
        lookupTracker.record(filePath, position, strAsString, lookupTracker2, strAsString2);
    }

    public static final void recordPackageLookup(LookupTracker lookupTracker, LookupLocation2 lookupLocation2, String str, String str2) {
        LookupLocation location;
        Intrinsics3.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics3.checkNotNullParameter(lookupLocation2, "from");
        Intrinsics3.checkNotNullParameter(str, "packageFqName");
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (lookupTracker == LookupTracker.a.f23110a || (location = lookupLocation2.getLocation()) == null) {
            return;
        }
        lookupTracker.record(location.getFilePath(), lookupTracker.getRequiresPosition() ? location.getPosition() : LookupLocation4.f23135j.getNO_POSITION(), str, LookupTracker2.PACKAGE, str2);
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation2 lookupLocation2, PackageFragmentDescriptor packageFragmentDescriptor, Name name) {
        Intrinsics3.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics3.checkNotNullParameter(lookupLocation2, "from");
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "scopeOwner");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = packageFragmentDescriptor.getFqName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "scopeOwner.fqName.asString()");
        String strAsString2 = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString2, "name.asString()");
        recordPackageLookup(lookupTracker, lookupLocation2, strAsString, strAsString2);
    }
}
