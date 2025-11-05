package com.discord.widgets.botuikit;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.botuikit.SelectItem;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.t.o0;
import d0.t.u;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: ComponentChatListState.kt */
/* loaded from: classes2.dex */
public final class ComponentChatListState {
    public static final ComponentChatListState INSTANCE = new ComponentChatListState();

    /* compiled from: ComponentChatListState.kt */
    public static final /* data */ class ComponentStoreState {
        private final boolean animateEmojis;
        private final Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState;
        private final Map<Integer, List<SelectItem>> selections;

        public ComponentStoreState() {
            this(null, null, false, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ComponentStoreState(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map, Map<Integer, ? extends List<SelectItem>> map2, boolean z2) {
            this.interactionState = map;
            this.selections = map2;
            this.animateEmojis = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ComponentStoreState copy$default(ComponentStoreState componentStoreState, Map map, Map map2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = componentStoreState.interactionState;
            }
            if ((i & 2) != 0) {
                map2 = componentStoreState.selections;
            }
            if ((i & 4) != 0) {
                z2 = componentStoreState.animateEmojis;
            }
            return componentStoreState.copy(map, map2, z2);
        }

        public final Map<Integer, StoreApplicationInteractions.InteractionSendState> component1() {
            return this.interactionState;
        }

        public final Map<Integer, List<SelectItem>> component2() {
            return this.selections;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final ComponentStoreState copy(Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> interactionState, Map<Integer, ? extends List<SelectItem>> selections, boolean animateEmojis) {
            return new ComponentStoreState(interactionState, selections, animateEmojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ComponentStoreState)) {
                return false;
            }
            ComponentStoreState componentStoreState = (ComponentStoreState) other;
            return m.areEqual(this.interactionState, componentStoreState.interactionState) && m.areEqual(this.selections, componentStoreState.selections) && this.animateEmojis == componentStoreState.animateEmojis;
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final Map<Integer, StoreApplicationInteractions.InteractionSendState> getInteractionState() {
            return this.interactionState;
        }

        public final Map<Integer, List<SelectItem>> getSelections() {
            return this.selections;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Map<Integer, StoreApplicationInteractions.InteractionSendState> map = this.interactionState;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Integer, List<SelectItem>> map2 = this.selections;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.animateEmojis;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("ComponentStoreState(interactionState=");
            sbU.append(this.interactionState);
            sbU.append(", selections=");
            sbU.append(this.selections);
            sbU.append(", animateEmojis=");
            return a.O(sbU, this.animateEmojis, ")");
        }

        public /* synthetic */ ComponentStoreState(Map map, Map map2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? h0.emptyMap() : map, (i & 2) != 0 ? h0.emptyMap() : map2, (i & 4) != 0 ? true : z2);
        }
    }

    /* compiled from: ComponentChatListState.kt */
    /* renamed from: com.discord.widgets.botuikit.ComponentChatListState$observeChatListComponentState$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>>, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>>, Boolean, Map<Long, ? extends ComponentStoreState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ Map<Long, ? extends ComponentStoreState> call(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<? extends SelectItem>>> map2, Boolean bool) {
            return call2(map, (Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>>) map2, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ComponentStoreState> call2(Map<Long, ? extends Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState>> map, Map<Long, ? extends Map<Integer, ? extends List<SelectItem>>> map2, Boolean bool) {
            List listDistinct = u.distinct(o0.plus((Set) map.keySet(), (Iterable) map2.keySet()));
            LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(listDistinct, 10)), 16));
            for (Object obj : listDistinct) {
                long jLongValue = ((Number) obj).longValue();
                Map<Integer, ? extends StoreApplicationInteractions.InteractionSendState> map3 = map.get(Long.valueOf(jLongValue));
                Map<Integer, ? extends List<SelectItem>> map4 = map2.get(Long.valueOf(jLongValue));
                m.checkNotNullExpressionValue(bool, "animateEmojis");
                linkedHashMap.put(obj, new ComponentStoreState(map3, map4, bool.booleanValue()));
            }
            return linkedHashMap;
        }
    }

    private ComponentChatListState() {
    }

    public final Observable<Map<Long, ComponentStoreState>> observeChatListComponentState() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, ComponentStoreState>> observableI = Observable.i(companion.getInteractions().observeComponentInteractionState(), companion.getLocalActionComponentState().observeSelectComponentSelections(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…s\n        )\n      }\n    }");
        return observableI;
    }
}
