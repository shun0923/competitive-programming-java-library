---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TreeMultiSet_test.java
    title: library/TreeMultiSet_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nclass\
    \ MultiSet<K> extends HashMap<K, Long> {\n\tlong cnt = 0;\n\tpublic final Long\
    \ add(K key) { return update(key, 1); }\n\tpublic final Long erase(K key) { return\
    \ update(key, -1); }\n\tpublic final Long update(K key, long value) {\n\t\tcnt\
    \ += value;\n\t\tLong prv = get(key);\n\t\tlong crt = convert(prv) + value;\n\t\
    \tif(crt < 0) throw new NoSuchElementException();\n\t\telse if(crt == 0) remove(key);\n\
    \t\telse put(key, crt);\n\t\treturn prv;\n\t}\n\tpublic final long count() { return\
    \ cnt; }\n\tpublic final long count(K key) { return convert(get(key)); }\n\n\t\
    private static final long convert(Long value) { return value == null ? 0 : value;\
    \ }\n}\n\nclass TreeMultiSet<K> extends TreeMap<K, Long> {\n\tprivate long cnt\
    \ = 0;\n\tpublic final Long add(K key) { return update(key, 1); }\n\tpublic final\
    \ Long erase(K key) { return update(key, -1); }\n\tpublic final Long update(K\
    \ key, long value) {\n\t\tcnt += value;\n\t\tLong prv = get(key);\n\t\tlong crt\
    \ = convert(prv) + value;\n\t\tif(crt < 0) throw new NoSuchElementException();\n\
    \t\telse if(crt == 0) remove(key);\n\t\telse put(key, crt);\n\t\treturn prv;\n\
    \t}\n\tpublic final long count() { return cnt; }\n\tpublic final long count(K\
    \ key) { return convert(get(key)); }\n\tpublic final boolean contains(K key) {\
    \ return containsKey(key); }\n\n\tpublic final K first() { return firstKey();\
    \ }\n\tpublic final long firstCount() { return convert(firstEntry().getValue());\
    \ }\n\tpublic final K last() { return lastKey(); }\n\tpublic final long lastCount()\
    \ { return convert(lastEntry().getValue()); }\n\tpublic final K floor(K key) {\
    \ return floorKey(key); }\n\tpublic final long floorCount(K key) { return convert(floorEntry(key).getValue());\
    \ }\n\tpublic final K ceiling(K key) { return ceilingKey(key); }\n\tpublic final\
    \ long ceilingCount(K key) { return convert(ceilingEntry(key).getValue()); }\n\
    \tpublic final K higher(K key) { return higherKey(key); }\n\tpublic final long\
    \ higherCount(K key) { return convert(higherEntry(key).getValue()); }\n\tpublic\
    \ final K lower(K key) { return lowerKey(key); }\n\tpublic final long lowerCount(K\
    \ key) { return convert(lowerEntry(key).getValue()); }\n\n\tpublic final K eraseFirst()\
    \ { K first = first(); erase(first); return first; }\n\tpublic final K removeFirst()\
    \ { K first = first(); remove(first); return first; }\n\tpublic final K eraseLast()\
    \ { K last = last(); erase(last); return last; }\n\tpublic final K removeLast()\
    \ { K last = last(); remove(last); return last; }\n\n\tprivate static final long\
    \ convert(Long value) { return value == null ? 0 : value; }\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/MultiSet.java
  requiredBy: []
  timestamp: '2022-10-05 22:12:54+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TreeMultiSet_test.java
documentation_of: library/MultiSet.java
layout: document
redirect_from:
- /library/library/MultiSet.java
- /library/library/MultiSet.java.html
title: library/MultiSet.java
---
