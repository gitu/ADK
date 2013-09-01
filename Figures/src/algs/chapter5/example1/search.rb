def sequentialSearch(collection, t)
  collection.each {
    |i| if i == t then return true; end 
  }
  return false
end
