package com.discord.models.domain;

import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ModelUserNote.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserNote {
    private final String note;
    private final long noteUserId;

    /* JADX INFO: compiled from: ModelUserNote.kt */
    public static final /* data */ class Update {
        private final long id;
        private final String note;

        /* JADX INFO: compiled from: ModelUserNote.kt */
        public static final class Parser implements Model.Parser<Update> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ Update parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Update parse(Model.JsonReader reader) throws IOException {
                Intrinsics3.checkNotNullParameter(reader, "reader");
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                ref$LongRef.element = 0L;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = "";
                reader.nextObject(new ModelUserNote2(ref$LongRef, reader, ref$ObjectRef));
                return new Update(ref$LongRef.element, (String) ref$ObjectRef.element);
            }
        }

        public Update(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "note");
            this.id = j;
            this.note = str;
        }

        public static /* synthetic */ Update copy$default(Update update, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = update.id;
            }
            if ((i & 2) != 0) {
                str = update.note;
            }
            return update.copy(j, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNote() {
            return this.note;
        }

        public final Update copy(long id2, String note) {
            Intrinsics3.checkNotNullParameter(note, "note");
            return new Update(id2, note);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Update)) {
                return false;
            }
            Update update = (Update) other;
            return this.id == update.id && Intrinsics3.areEqual(this.note, update.note);
        }

        public final long getId() {
            return this.id;
        }

        public final String getNote() {
            return this.note;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.note;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Update(id=");
            sbM833U.append(this.id);
            sbM833U.append(", note=");
            return outline.m822J(sbM833U, this.note, ")");
        }
    }

    public ModelUserNote(long j, String str) {
        this.noteUserId = j;
        this.note = str;
    }

    public static /* synthetic */ ModelUserNote copy$default(ModelUserNote modelUserNote, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelUserNote.noteUserId;
        }
        if ((i & 2) != 0) {
            str = modelUserNote.note;
        }
        return modelUserNote.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getNoteUserId() {
        return this.noteUserId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final ModelUserNote copy(long noteUserId, String note) {
        return new ModelUserNote(noteUserId, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserNote)) {
            return false;
        }
        ModelUserNote modelUserNote = (ModelUserNote) other;
        return this.noteUserId == modelUserNote.noteUserId && Intrinsics3.areEqual(this.note, modelUserNote.note);
    }

    public final String getNote() {
        return this.note;
    }

    public final long getNoteUserId() {
        return this.noteUserId;
    }

    public int hashCode() {
        long j = this.noteUserId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.note;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelUserNote(noteUserId=");
        sbM833U.append(this.noteUserId);
        sbM833U.append(", note=");
        return outline.m822J(sbM833U, this.note, ")");
    }
}
