(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  #(contains? a-set %))

(defn pred-and [pred1 pred2]
  #(and (pred1 %) (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
 (every? #(has-award? book %) awards)) 

(defn my-some [pred a-seq]
  (let [res (filter pred a-seq)]
    (if (empty? res)
      nil
      (pred (first res)))))

(defn my-every? [pred a-seq]
  (apply = (cons true (map pred a-seq))))

(defn prime? [n]
  (if (== n 2)
      true
      (every?
        #(not (= 0 (rem n %)))
        (range 2 (inc (Math/ceil (Math/sqrt n)))))))
;^^
