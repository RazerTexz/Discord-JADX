package com.discord.models.domain;

import com.discord.models.domain.Model;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelGuildFolder.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelGuildFolder {
    private final Integer color;
    private final List<Long> guildIds;
    private final Long id;
    private final String name;

    /* compiled from: ModelGuildFolder.kt */
    public static final class Parser implements Model.Parser<ModelGuildFolder> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelGuildFolder parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelGuildFolder parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefM844c0 = outline.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextObject(new ModelGuildFolder2(ref$ObjectRefM844c0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
            Long l = (Long) ref$ObjectRefM844c0.element;
            List list = (List) ref$ObjectRef.element;
            Intrinsics3.checkNotNull(list);
            return new ModelGuildFolder(l, list, (Integer) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
        }
    }

    public ModelGuildFolder(Long l, List<Long> list, Integer num, String str) {
        Intrinsics3.checkNotNullParameter(list, "guildIds");
        this.id = l;
        this.guildIds = list;
        this.color = num;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelGuildFolder copy$default(ModelGuildFolder modelGuildFolder, Long l, List list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelGuildFolder.id;
        }
        if ((i & 2) != 0) {
            list = modelGuildFolder.guildIds;
        }
        if ((i & 4) != 0) {
            num = modelGuildFolder.color;
        }
        if ((i & 8) != 0) {
            str = modelGuildFolder.name;
        }
        return modelGuildFolder.copy(l, list, num, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    public final List<Long> component2() {
        return this.guildIds;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelGuildFolder copy(Long id2, List<Long> guildIds, Integer color, String name) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        return new ModelGuildFolder(id2, guildIds, color, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildFolder)) {
            return false;
        }
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) other;
        return Intrinsics3.areEqual(this.id, modelGuildFolder.id) && Intrinsics3.areEqual(this.guildIds, modelGuildFolder.guildIds) && Intrinsics3.areEqual(this.color, modelGuildFolder.color) && Intrinsics3.areEqual(this.name, modelGuildFolder.name);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final List<Long> getGuildIds() {
        return this.guildIds;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.guildIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.color;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelGuildFolder(id=");
        sbM833U.append(this.id);
        sbM833U.append(", guildIds=");
        sbM833U.append(this.guildIds);
        sbM833U.append(", color=");
        sbM833U.append(this.color);
        sbM833U.append(", name=");
        return outline.m822J(sbM833U, this.name, ")");
    }

    public /* synthetic */ ModelGuildFolder(Long l, List list, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, list, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str);
    }
}
