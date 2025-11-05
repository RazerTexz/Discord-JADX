package com.discord.widgets.chat.input.gifpicker;

import androidx.annotation.StringRes;
import b.d.b.a.a;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GifAdapterItem.kt */
/* loaded from: classes2.dex */
public abstract class GifAdapterItem implements DiffKeyProvider {
    private final ViewType type;

    /* compiled from: GifAdapterItem.kt */
    public static abstract class SuggestedTermsItem extends GifAdapterItem {
        private final List<String> terms;
        private final int titleResId;
        private final ViewType viewType;

        /* compiled from: GifAdapterItem.kt */
        public static final /* data */ class SuggestedTermsEmptyResults extends SuggestedTermsItem {
            private final List<String> terms;
            private final int titleResId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedTermsEmptyResults(List<String> list, int i) {
                super(list, ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS, i, null);
                m.checkNotNullParameter(list, "terms");
                this.terms = list;
                this.titleResId = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SuggestedTermsEmptyResults copy$default(SuggestedTermsEmptyResults suggestedTermsEmptyResults, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = suggestedTermsEmptyResults.getTerms();
                }
                if ((i2 & 2) != 0) {
                    i = suggestedTermsEmptyResults.getTitleResId();
                }
                return suggestedTermsEmptyResults.copy(list, i);
            }

            public final List<String> component1() {
                return getTerms();
            }

            public final int component2() {
                return getTitleResId();
            }

            public final SuggestedTermsEmptyResults copy(List<String> terms, int titleResId) {
                m.checkNotNullParameter(terms, "terms");
                return new SuggestedTermsEmptyResults(terms, titleResId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedTermsEmptyResults)) {
                    return false;
                }
                SuggestedTermsEmptyResults suggestedTermsEmptyResults = (SuggestedTermsEmptyResults) other;
                return m.areEqual(getTerms(), suggestedTermsEmptyResults.getTerms()) && getTitleResId() == suggestedTermsEmptyResults.getTitleResId();
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public List<String> getTerms() {
                return this.terms;
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public int getTitleResId() {
                return this.titleResId;
            }

            public int hashCode() {
                List<String> terms = getTerms();
                return getTitleResId() + ((terms != null ? terms.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = a.U("SuggestedTermsEmptyResults(terms=");
                sbU.append(getTerms());
                sbU.append(", titleResId=");
                sbU.append(getTitleResId());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GifAdapterItem.kt */
        public static final /* data */ class SuggestedTermsNonEmptyResults extends SuggestedTermsItem {
            private final List<String> terms;
            private final int titleResId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedTermsNonEmptyResults(List<String> list, int i) {
                super(list, ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_NON_EMPTY_RESULTS, i, null);
                m.checkNotNullParameter(list, "terms");
                this.terms = list;
                this.titleResId = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SuggestedTermsNonEmptyResults copy$default(SuggestedTermsNonEmptyResults suggestedTermsNonEmptyResults, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = suggestedTermsNonEmptyResults.getTerms();
                }
                if ((i2 & 2) != 0) {
                    i = suggestedTermsNonEmptyResults.getTitleResId();
                }
                return suggestedTermsNonEmptyResults.copy(list, i);
            }

            public final List<String> component1() {
                return getTerms();
            }

            public final int component2() {
                return getTitleResId();
            }

            public final SuggestedTermsNonEmptyResults copy(List<String> terms, int titleResId) {
                m.checkNotNullParameter(terms, "terms");
                return new SuggestedTermsNonEmptyResults(terms, titleResId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedTermsNonEmptyResults)) {
                    return false;
                }
                SuggestedTermsNonEmptyResults suggestedTermsNonEmptyResults = (SuggestedTermsNonEmptyResults) other;
                return m.areEqual(getTerms(), suggestedTermsNonEmptyResults.getTerms()) && getTitleResId() == suggestedTermsNonEmptyResults.getTitleResId();
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public List<String> getTerms() {
                return this.terms;
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public int getTitleResId() {
                return this.titleResId;
            }

            public int hashCode() {
                List<String> terms = getTerms();
                return getTitleResId() + ((terms != null ? terms.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = a.U("SuggestedTermsNonEmptyResults(terms=");
                sbU.append(getTerms());
                sbU.append(", titleResId=");
                sbU.append(getTitleResId());
                sbU.append(")");
                return sbU.toString();
            }
        }

        public /* synthetic */ SuggestedTermsItem(List list, ViewType viewType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, viewType, i);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return String.valueOf((u.joinToString$default(getTerms(), null, null, null, 0, null, null, 63, null) + getTitleResId()).hashCode());
        }

        public List<String> getTerms() {
            return this.terms;
        }

        public int getTitleResId() {
            return this.titleResId;
        }

        public final ViewType getViewType() {
            return this.viewType;
        }

        private SuggestedTermsItem(List<String> list, ViewType viewType, @StringRes int i) {
            super(viewType, null);
            this.terms = list;
            this.viewType = viewType;
            this.titleResId = i;
        }
    }

    /* compiled from: GifAdapterItem.kt */
    public enum ViewType {
        VIEW_TYPE_GIF_ITEM,
        VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS,
        VIEW_TYPE_GIF_SEARCH_TERMS_NON_EMPTY_RESULTS;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ViewType[] values = values();

        /* compiled from: GifAdapterItem.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ViewType fromInt(int index) {
                return ViewType.access$getValues$cp()[index];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final /* synthetic */ ViewType[] access$getValues$cp() {
            return values;
        }
    }

    private GifAdapterItem(ViewType viewType) {
        this.type = viewType;
    }

    public final ViewType getType() {
        return this.type;
    }

    /* compiled from: GifAdapterItem.kt */
    public static final /* data */ class GifItem extends GifAdapterItem {
        private final ModelGif gif;
        private final String key;
        private final String query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifItem(ModelGif modelGif, String str) {
            super(ViewType.VIEW_TYPE_GIF_ITEM, null);
            m.checkNotNullParameter(modelGif, IconUtils.ANIMATED_IMAGE_EXTENSION);
            this.gif = modelGif;
            this.query = str;
            this.key = String.valueOf(hashCode());
        }

        public static /* synthetic */ GifItem copy$default(GifItem gifItem, ModelGif modelGif, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                modelGif = gifItem.gif;
            }
            if ((i & 2) != 0) {
                str = gifItem.query;
            }
            return gifItem.copy(modelGif, str);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelGif getGif() {
            return this.gif;
        }

        /* renamed from: component2, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final GifItem copy(ModelGif gif, String query) {
            m.checkNotNullParameter(gif, IconUtils.ANIMATED_IMAGE_EXTENSION);
            return new GifItem(gif, query);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GifItem)) {
                return false;
            }
            GifItem gifItem = (GifItem) other;
            return m.areEqual(this.gif, gifItem.gif) && m.areEqual(this.query, gifItem.query);
        }

        public final ModelGif getGif() {
            return this.gif;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getQuery() {
            return this.query;
        }

        public int hashCode() {
            ModelGif modelGif = this.gif;
            int iHashCode = (modelGif != null ? modelGif.hashCode() : 0) * 31;
            String str = this.query;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("GifItem(gif=");
            sbU.append(this.gif);
            sbU.append(", query=");
            return a.J(sbU, this.query, ")");
        }

        public /* synthetic */ GifItem(ModelGif modelGif, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(modelGif, (i & 2) != 0 ? "" : str);
        }
    }

    public /* synthetic */ GifAdapterItem(ViewType viewType, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewType);
    }
}
