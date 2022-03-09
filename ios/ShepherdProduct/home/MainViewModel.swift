//
//  MainViewModel.swift
//  ShepherdProduct
//
//  Created by k4keye on 2022/03/09.
//

import Foundation


class MainViewModel : ObservableObject{
    @Published var result : SearchResult = SearchResult(code: false, items: nil)
    @Published var searching : Bool = false
    func search(searchText:String, searchType:SearchType){
        self.searching = true
        do{
            let url = try getApiUrl(searchText: searchText, searchType: searchType)
            
            let task = URLSession.shared.dataTask(with: url){ data, _, error in
                guard let data = data, error == nil else {
                    return
                }
                
                print("api data : \(data)")
                guard let model = try? JSONDecoder().decode(SearchEntity.self, from: data) else{
                    print("api decode faild")
                    self.result = SearchResult(code: false, items: nil)
                    return
                }
                DispatchQueue.main.async {
                    self.result = SearchResult(code: true, items: model.body.items)
                }
                
                print("api data model : \(model)")
            }
            task.resume()

        }catch{
            print("faild \(error)")
        }
      
        
     
    }
    
    private func getApiUrl(searchText:String, searchType:SearchType) throws -> URL {

        let baseUrl = "http://apis.data.go.kr/1471000/FoodFlshdErtsInfoService02/getFoodFlshdErtsList?"
        
        let serviceKey : String = "ServiceKey="+"ecRUAWQCCIj7fved9BSoyYhkCrLWpUswHZ6bq5I635bB0GG76X5Mc4Wv11MWAfPz3B01eprG1KmgWX46Qlw3oA=="
        let pageNo : String = "pageNo="+"1"
        let type : String = "type="+"json"
        let searchText : String = searchType == SearchType.Company ? "Entrps=\(searchText)" : "Prduct=\(searchText)"
        
        let url = "\(baseUrl)\(serviceKey)&\(pageNo)&\(type)&\(searchText)"
        
        print("create URL : \(url)")
        
        //한글이있을경우 인코딩
        let encodedString = url.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)!

        guard let url = URL(string: encodedString)else{
            print("api url faild")
            throw FaildError.apiURLMismatch
        }
        
        return url
      
        
    }
    
    func testClick(){
        print("hello world")
    }
    

    
}
