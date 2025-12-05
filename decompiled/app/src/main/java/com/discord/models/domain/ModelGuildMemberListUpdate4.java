package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: ModelGuildMemberListUpdate.kt */
/* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelGuildMemberListUpdate4<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $index;
    public final /* synthetic */ Ref$ObjectRef $item;
    public final /* synthetic */ Ref$ObjectRef $items;
    public final /* synthetic */ Ref$ObjectRef $range;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $type;

    /* compiled from: ModelGuildMemberListUpdate.kt */
    /* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1$1 */
    public static final class C55361<T> implements Model.JsonReader.ItemFactory<Integer> {
        public C55361() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Integer get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final Integer get() {
            return ModelGuildMemberListUpdate4.this.$reader.nextIntOrNull();
        }
    }

    /* compiled from: ModelGuildMemberListUpdate.kt */
    /* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1$3 */
    public static final class C55373<T> implements Model.JsonReader.ItemFactory<ModelGuildMemberListUpdate.Operation.Item> {
        public C55373() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate.Operation.Item get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelGuildMemberListUpdate.Operation.Item get() {
            return ModelGuildMemberListUpdate.Operation.Item.Parser.INSTANCE.parse(ModelGuildMemberListUpdate4.this.$reader);
        }
    }

    public ModelGuildMemberListUpdate4(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        this.$type = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$index = ref$ObjectRef2;
        this.$range = ref$ObjectRef3;
        this.$item = ref$ObjectRef4;
        this.$items = ref$ObjectRef5;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case 3553:
                    if (str.equals("op")) {
                        this.$type.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 3242771:
                    if (str.equals("item")) {
                        this.$item.element = (T) ModelGuildMemberListUpdate.Operation.Item.Parser.INSTANCE.parse(this.$reader);
                        return;
                    }
                    break;
                case 100346066:
                    if (str.equals("index")) {
                        this.$index.element = (T) this.$reader.nextIntOrNull();
                        return;
                    }
                    break;
                case 100526016:
                    if (str.equals("items")) {
                        this.$items.element = (T) this.$reader.nextList(new C55373());
                        return;
                    }
                    break;
                case 108280125:
                    if (str.equals("range")) {
                        Ref$ObjectRef ref$ObjectRef = this.$range;
                        List<T> listNextList = this.$reader.nextList(new C55361());
                        T t = listNextList.get(0);
                        Intrinsics3.checkNotNullExpressionValue(t, "it[0]");
                        int iIntValue = ((Number) t).intValue();
                        T t2 = listNextList.get(1);
                        Intrinsics3.checkNotNullExpressionValue(t2, "it[1]");
                        ref$ObjectRef.element = (T) new Ranges2(iIntValue, ((Number) t2).intValue());
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
