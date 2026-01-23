package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11590w;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t.Collections2;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.b, reason: use source file name */
/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DeclaredMemberIndex2 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.b$a */
    /* JADX INFO: compiled from: DeclaredMemberIndex.kt */
    public static final class a implements DeclaredMemberIndex2 {

        /* JADX INFO: renamed from: a */
        public static final a f23328a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
        public InterfaceC11581n findFieldByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
        public /* bridge */ /* synthetic */ Collection findMethodsByName(Name name) {
            return findMethodsByName(name);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
        public InterfaceC11590w findRecordComponentByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
        public Set<Name> getFieldNames() {
            return Sets5.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
        public Set<Name> getMethodNames() {
            return Sets5.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
        public Set<Name> getRecordComponentNames() {
            return Sets5.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
        public List<InterfaceC11585r> findMethodsByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return Collections2.emptyList();
        }
    }

    InterfaceC11581n findFieldByName(Name name);

    Collection<InterfaceC11585r> findMethodsByName(Name name);

    InterfaceC11590w findRecordComponentByName(Name name);

    Set<Name> getFieldNames();

    Set<Name> getMethodNames();

    Set<Name> getRecordComponentNames();
}
