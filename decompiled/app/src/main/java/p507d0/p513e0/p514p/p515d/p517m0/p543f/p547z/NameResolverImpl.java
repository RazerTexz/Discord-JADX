package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.LinkedList;
import java.util.List;
import kotlin.Tuples3;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11690o;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11691p;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.d, reason: use source file name */
/* JADX INFO: compiled from: NameResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NameResolverImpl implements NameResolver {

    /* JADX INFO: renamed from: a */
    public final C11691p f24059a;

    /* JADX INFO: renamed from: b */
    public final C11690o f24060b;

    public NameResolverImpl(C11691p c11691p, C11690o c11690o) {
        Intrinsics3.checkNotNullParameter(c11691p, "strings");
        Intrinsics3.checkNotNullParameter(c11690o, "qualifiedNames");
        this.f24059a = c11691p;
        this.f24060b = c11690o;
    }

    /* JADX INFO: renamed from: a */
    public final Tuples3<List<String>, List<String>, Boolean> m9815a(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z2 = false;
        while (i != -1) {
            C11690o.c qualifiedName = this.f24060b.getQualifiedName(i);
            String string = this.f24059a.getString(qualifiedName.getShortName());
            C11690o.c.EnumC13322c kind = qualifiedName.getKind();
            Intrinsics3.checkNotNull(kind);
            int iOrdinal = kind.ordinal();
            if (iOrdinal == 0) {
                linkedList2.addFirst(string);
            } else if (iOrdinal == 1) {
                linkedList.addFirst(string);
            } else if (iOrdinal == 2) {
                linkedList2.addFirst(string);
                z2 = true;
            }
            i = qualifiedName.getParentQualifiedName();
        }
        return new Tuples3<>(linkedList, linkedList2, Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver
    public String getQualifiedClassName(int i) {
        Tuples3<List<String>, List<String>, Boolean> tuples3M9815a = m9815a(i);
        List<String> listComponent1 = tuples3M9815a.component1();
        String strJoinToString$default = _Collections.joinToString$default(tuples3M9815a.component2(), ".", null, null, 0, null, null, 62, null);
        if (listComponent1.isEmpty()) {
            return strJoinToString$default;
        }
        return _Collections.joinToString$default(listComponent1, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, null, null, 0, null, null, 62, null) + MentionUtils.SLASH_CHAR + strJoinToString$default;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver
    public String getString(int i) {
        String string = this.f24059a.getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver
    public boolean isLocalClassName(int i) {
        return m9815a(i).getThird().booleanValue();
    }
}
